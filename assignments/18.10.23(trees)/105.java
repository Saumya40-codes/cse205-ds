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

    private static TreeNode calc(int[] pre, int ps, int pe, int[] in, int is, int ie, HashMap<Integer,Integer> map){

        if(ps > pe || is > ie) return null;

        TreeNode curr = new TreeNode(pre[ps]);
        int idx = map.get(curr.val);
        int toLeft = idx-is;

        curr.left  = calc(pre,ps+1,ps+toLeft,in,is,idx-1,map);
        curr.right = calc(pre,ps+toLeft+1,pe,in,idx+1,ie,map);

        return curr;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }

        TreeNode root = calc(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
  }
}