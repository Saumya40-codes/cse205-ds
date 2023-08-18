class Solution {

    private static void combi(int[] arr, List<List<Integer>> ans, List<Integer> lst, int tar, int idx){
        if(tar == 0){
            ans.add(new ArrayList<>(lst));
            return;
        }

        for(int i = idx ; i < arr.length ; i++){
            if(i > idx && arr[i] == arr[i-1]) continue;

            if(arr[i] > tar) break;

            lst.add(arr[i]);
            combi(arr,ans,lst,tar-arr[i],i+1);
            lst.remove(lst.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);

        combi(candidates, ans, new ArrayList<>(), target, 0);
        return ans;
    }
}