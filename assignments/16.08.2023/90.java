class Solution {

    private static void subseq(int[] nums, int idx, List<Integer> lst , List<List<Integer>>  ans){

        if( idx >= nums.length){
            if(!(ans.contains(new ArrayList<>(lst))))
                ans.add(new ArrayList<>(lst));
            return;
        }

            lst.add(nums[idx]);
            subseq(nums,idx+1,lst,ans);
            lst.remove(lst.size()-1);
            subseq(nums,idx+1,lst,ans);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>>  ans = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        Arrays.sort(nums);
        subseq(nums, 0, lst, ans);
        return ans;
    }
}
