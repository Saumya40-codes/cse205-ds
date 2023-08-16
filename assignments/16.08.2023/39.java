class Solution {

    private static void combSum(int[] arr, List<List<Integer>> ans, int tar, int sum, List<Integer> lst, int idx){

        if(idx >= arr.length){
            return;
        }
        
        if(sum == tar){
            ans.add(new ArrayList<>(lst));
            return;
        }

        if(sum > tar){
            return;
        }

        sum += arr[idx];
        lst.add(arr[idx]);
        combSum(arr, ans, tar, sum ,lst, idx);
        sum -= arr[idx];
        lst.remove(lst.size()-1);
        combSum(arr, ans, tar, sum ,lst, idx+1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> lst  = new ArrayList<>();

        combSum(candidates, ans, target, 0, lst, 0);
        return ans;
    }
}