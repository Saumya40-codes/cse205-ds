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

    private static void inorder(TreeNode head, List<Integer> lst){
        if(head == null){
            return;
        }

        inorder(head.left,lst);
        lst.add(head.val);
        inorder(head.right,lst);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();

        if(root == null) return lst;
        // inorder(root,lst);

        Stack<TreeNode> s = new Stack<>();

        TreeNode curr =root;

        while(true){
            if(curr != null){
                s.push(curr);
                curr = curr.left;
            }
            else{

                if(s.isEmpty()) break;

                curr = s.peek();

                lst.add(curr.val);

                s.pop();
                curr = curr.right;
            }
        }
        return lst;
    }
}