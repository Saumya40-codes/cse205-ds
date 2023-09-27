class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        boolean[] visited = new boolean[nums.length];

        for(int i = nums.length*2-1; i >= 0; i--){
            // if(!stack.isEmpty() && stack.peek() > nums[i%nums.length]){
            //     ans[i%nums.length] = stack.peek();
            // }
            if(!visited[i%nums.length]){

            while(!stack.isEmpty() && stack.peek() <= nums[i%nums.length]){
                stack.pop();
            }

            if(stack.isEmpty()){
                ans[i%nums.length] = -1;
            }
            else{
                visited[i%nums.length] = true;
                ans[i%nums.length] = stack.peek();
            }

            stack.push(nums[i%nums.length]);
            }
        }

        // System.out.println(map);

        return ans;
    }
}