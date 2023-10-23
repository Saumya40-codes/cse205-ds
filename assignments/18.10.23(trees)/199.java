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
    class Pair{
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();

        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));

        while(!q.isEmpty()){
            Pair temp = q.poll();
            TreeNode top = temp.node;
            int l = temp.level;

            map.put(l,top.val);

            if(top.left != null) q.offer(new Pair(top.left,l+1));
            if(top.right != null) q.offer(new Pair(top.right,l+1));
        }

        List<Integer> ans = new ArrayList<>();
        
        for(int num: map.values()){
            ans.add(num);
        }

        return ans;
    }
}