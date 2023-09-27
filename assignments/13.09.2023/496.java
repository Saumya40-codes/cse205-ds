class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();           // to check/ store most recently entered value
        HashMap<Integer,Integer> map = new HashMap<>(); // keeping the track of next greater element

        // for(int num: nums2){
        //     while(!stack.isEmpty() && stack.peek() < num){ // means we found NGE of the peek element of the stack
        //         map.put(stack.pop(),num);
        //     }

        //     stack.push(num);
        // }

        for(int i = nums2.length-1; i >= 0; i--){
            if(!stack.isEmpty() && stack.peek() > nums2[i]){
                map.put(nums2[i],stack.peek());
            }


            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                stack.pop();
                if(!stack.isEmpty()){
                    map.put(nums2[i],stack.peek());
                }
            }
            if(stack.isEmpty()){
                map.put(nums2[i],-1);
            }

            stack.push(nums2[i]);
        }

        for(int i = 0; i < nums1.length; i++){
            nums1[i] = map.getOrDefault(nums1[i],-1);
        }

        return nums1;
    }
}