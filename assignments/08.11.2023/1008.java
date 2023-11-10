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

    private static TreeNode calc(int[] pre, int bound, int[] idx){
        if(idx[0] >= pre.length || pre[idx[0]] > bound) return null;

        TreeNode curr = new TreeNode(pre[idx[0]++]);

        curr.left = calc(pre,curr.val,idx);
        curr.right = calc(pre,bound,idx);

        return curr;
    }
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return calc(preorder,Integer.MAX_VALUE,new int[]{0});
    }
}