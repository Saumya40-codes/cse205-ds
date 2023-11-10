/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private static TreeNode first;
    private static TreeNode middle;
    private static TreeNode last;
    private static TreeNode prev;

    private static void calc(TreeNode root){
        if(root == null) return;

        calc(root.left);

        if(prev != null && root.val < prev.val){
            
            // System.out.println(root != null?root.val:"");
            // System.out.println(prev != null?prev.val:"");

            if(first == null){
                first = prev;
                middle = root;
            }

            else{
                last = root;
            }
        }

        prev = root;
        calc(root.right);
    }
    public void recoverTree(TreeNode root) {
        first = null;
        middle = null;
        last = null;

        prev = new TreeNode(Integer.MIN_VALUE);

        calc(root);

        // System.out.println(first != null?first.val:"");
        // System.out.println(middle != null?middle.val:"");
        // System.out.println(last != null?last.val:"");

        if(first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
        else{
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
}