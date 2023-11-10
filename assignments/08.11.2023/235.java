/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;

        TreeNode curr = root;

        while(curr != null){
            if(curr.val < p.val && curr.val < q.val) curr = curr.right;
            else if(curr.val > p.val && curr.val > q.val) curr = curr.left;

            else break;
        }        

        return curr;
    }
}