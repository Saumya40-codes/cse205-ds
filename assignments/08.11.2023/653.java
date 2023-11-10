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

    private static boolean inorder(TreeNode root, int k, HashMap<Integer,Integer> map){
        if(root == null) return false;

        if(map.containsKey(k-root.val)) return true;
 
        boolean left = inorder(root.left,k,map);
        if(root!= null && map.containsKey(k-root.val)) return true;

        if(root != null) map.put(root.val,map.getOrDefault(root.val,0)+1);
        boolean right = inorder(root.right,k,map);

        return left||right;
    }

    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        // map.put(0,0);

        return inorder(root,k,map);
    }
}