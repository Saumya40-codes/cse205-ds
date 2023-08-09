class Solution {
    private static void subseq(int[] arr, List<List<Integer>> lst, int idx, List<Integer> store){
        if(idx >= arr.length){
            lst.add(new ArrayList<>(store));
            return;
        }
        store.add(arr[idx]);
        subseq(arr,lst,idx+1,store);
        store.remove(store.size()-1);
        subseq(arr,lst,idx+1,store);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans  = new ArrayList<>();
        subseq(nums,ans,0,new ArrayList<>());
        return ans;
    }
}