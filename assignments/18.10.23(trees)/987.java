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
    class Tuple{
        TreeNode node;
        int verti;
        int level;

        public Tuple(TreeNode node,int verti,int level){
            this.node = node;
            this.verti = verti;
            this.level = level;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        // it will be like (vertical,(level,node.val)); // pq because we want sorted order // treemap will get value in ascending order
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root,0,0));

        while(!q.isEmpty()){
            Tuple temp = q.poll();
            TreeNode top = temp.node;
            int v = temp.verti;
            int l = temp.level;

            map.putIfAbsent(v,new TreeMap<>()); // if no vertical then create its instance 
            if(!map.get(v).containsKey(l)){    //  if no level
                map.get(v).put(l,new PriorityQueue<>());
            }
            map.get(v).get(l).offer(top.val);

            if(top.left != null) q.offer(new Tuple(top.left,v-1,l+1));
            if(top.right != null) q.offer(new Tuple(top.right,v+1,l+1));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(TreeMap<Integer,PriorityQueue<Integer>> vals:map.values()){
            ans.add(new ArrayList<>()); // at the end of the list
            for(PriorityQueue<Integer> pq:vals.values()){
                while(!pq.isEmpty()){
                    ans.get(ans.size()-1).add(pq.poll());
                }
            }
        }

        return ans;
    }
}