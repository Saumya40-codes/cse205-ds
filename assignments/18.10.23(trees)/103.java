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

 // same as level order traversel, though reverse the list if flag = 1 and keep flipping flag value for every itteration
 
 class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int flag = 0;
        List<List<Integer>> ans = new ArrayList<>();

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> lst = new ArrayList<>();

            for(int i = 0; i < size; i++){
                TreeNode top = queue.poll();
                if(top.left != null) queue.offer(top.left);
                if(top.right != null) queue.offer(top.right);

                lst.add(top.val);
            }
            if(flag == 0){
                flag = 1;
            }
            else{
                Collections.reverse(lst);
                flag = 0;
            }
            ans.add(new ArrayList<>(lst));
        }

        return ans;
    }
}