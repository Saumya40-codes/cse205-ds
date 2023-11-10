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

    private static TreeNode getRight(TreeNode root){
        if(root.right == null) return root;

        return getRight(root.right);
    }

    private static TreeNode calc(TreeNode root){
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;

        TreeNode rightChild = root.right;
        TreeNode lastRight = getRight(root.left);
        lastRight.right = rightChild;

        return root.left;
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null) return root;

        if(root.val == key){
            return calc(root);
        }

        TreeNode curr = root;

        while(curr != null){
            if(curr.val > key){
                if(curr.left != null && curr.left.val == key){
                    curr.left = calc(curr.left);
                    break;
                }
                else{
                    curr = curr.left;
                }
            }
            else{
                if(curr.right != null && curr.right.val == key){
                    curr.right = calc(curr.right);
                    break;
                }
                else{
                    curr = curr.right;
                }
            }
        }

        return root;
    }
}