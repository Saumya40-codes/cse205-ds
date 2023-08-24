class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1; i <= n ; i++){ // rows

            List<Integer> lst = new ArrayList<>();

            int sum = 1;

            lst.add(sum);

            for(int j = 1; j < i ; j++){  // cols

                sum *= (i-j);
                sum /= j;

                lst.add(sum);
            }

            ans.add(new ArrayList<>(lst));
        }

        return ans;
    }
}

/*

to find value in pascals triangle at any particular row or column -> row-1 C col-1 (using this approach wont be optimized)

now on seeing the last row first we can see the sequence as

1 , 1 * ( row-col/col ) , 1 * prev * ( same operation ), .... 
*/