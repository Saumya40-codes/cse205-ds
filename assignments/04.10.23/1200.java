import java.util.*;
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length-1;i++){
            min = Math.min(min,Math.abs(arr[i]-arr[i+1]));
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < arr.length-1; i++){
            if(arr[i+1]-arr[i] == min){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i+1]);

                ans.add(new ArrayList<>(temp));
            }
        }
        return ans;
    }
}