class Solution {

    private static void perms(int[] arr, List<Integer> lst, List<List<Integer>> ans){
        if(lst.size() == arr.length){
            ans.add(new ArrayList<>(lst));

            return;
        }


        for(int val: arr){
            if(!lst.contains(val)){
                lst.add(val);
                perms(arr, lst, ans);
                lst.remove(lst.size()-1);
            }
        }
        
    }


    public List<List<Integer>> permute(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        perms(nums, lst, ans);

        return ans;
    }
}