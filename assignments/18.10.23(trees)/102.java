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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Stack<TreeNode> queue = new Stack<>();
        queue.push(root);
        List<List<Integer>> ans = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> lst = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode top = queue.pop();
                if(top.right != null) queue.push(top.right);
                if(top.left != null) queue.push(top.left);
                lst.add(top.val);
            }
            ans.add(new ArrayList<>(lst));
        }

        return ans;
    }
}