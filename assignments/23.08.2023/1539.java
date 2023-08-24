class Solution {
    public int findKthPositive(int[] arr, int k) {

        int pnt = 0;

        for(int i = 1; i <= arr[arr.length-1] ; i++){

            if(pnt < arr.length){
            if(arr[pnt] == i){
                pnt++;
            }
            else{
                k--;
            }
            }

            else{
                break;
            }

            if(k == 0){
                return i;
            }
        }
        return arr[arr.length-1] + k;
    }
}
