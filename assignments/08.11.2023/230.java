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

    private static TreeNode calc(TreeNode root, int[] cnt, int k){

        if(root == null){
            return  null;
        }

       TreeNode left = calc(root.left,cnt,k);

    //    System.out.println(left != null ? left.val:null);

       if(left != null) return left;

       cnt[0]++;

       if(cnt[0] == k) return root;

       return calc(root.right,cnt,k);
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] cnt = new int[1];
        TreeNode ans = calc(root,cnt,k);

        return ans.val;
    }
}