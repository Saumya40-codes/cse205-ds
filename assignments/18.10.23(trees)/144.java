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
    private static void pre(TreeNode root, List<Integer> lst){
        if(root == null){
            return;
        }

        lst.add(root.val);
        pre(root.left,lst);
        pre(root.right,lst);
    }
    public List<Integer> preorderTraversal(TreeNode root) {

        if(root == null) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        // pre(root,ans);

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode top = stack.pop();

            if(top.right != null) stack.push(top.right);
            if(top.left != null) stack.push(top.left);

            ans.add(top.val);
        }
        return ans;
    }
}