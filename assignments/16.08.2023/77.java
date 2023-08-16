class Solution {

    private static void comb(int n, int start, List<List<Integer>> ans, List<Integer> lst, int k){
        
        if(lst.size() == k){
            ans.add(new ArrayList<>(lst));
            return;
        }

        for(int i = start; i <= n ; i++){
            lst.add(i);
            comb(n, i + 1, ans, lst, k);
            lst.remove(lst.size()-1);
        }
    }


    public List<List<Integer>> combine(int n, int k) {
        List<Integer> lst = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        comb(n, 1, ans, lst, k);
        return ans;
    }
}