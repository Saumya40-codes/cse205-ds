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
    private static void post(TreeNode root, List<Integer> lst){
        if(root == null){
            return;
        }

        post(root.left,lst);
        post(root.right,lst);
        lst.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;
        // post(root,ans);

        Stack<TreeNode> s = new Stack<>();

        s.push(root);

        while(!s.isEmpty()){
            TreeNode top = s.pop();
            ans.add(top.val);

            if(top.left != null) s.push(top.left);
            if(top.right != null) s.push(top.right);
        }

        Collections.reverse(ans);
        return ans;
    }
}