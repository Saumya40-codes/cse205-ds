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

 // mix of both: height of BT and diameter of BT 
 // Math.max(0,calc(root.left,max)) for the case where the returning value is -ve thus it wont be taken for the max part of the path
 class Solution {

    private static int calc(TreeNode root, int[] max){
        if(root == null) return 0;

        int left = Math.max(0,calc(root.left,max));
        int right = Math.max(0,calc(root.right,max));

        max[0] = Math.max(max[0],root.val+left+right);

        return root.val+Math.max(left,right);
    }

    public int maxPathSum(TreeNode root) {
        if(root.left == null && root.right == null) return root.val;
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        int h = calc(root,max);
        return max[0];
    }
}