class Solution {

    static void merge(int[] arr, int l, int m, int r){

        int n1 = m-l+1;
        int n2 = r-m;

        int[] le = new int[n1];
        int[] ri = new int[n2];

        for(int i = 0; i < n1; i++){
            le[i] = arr[l+i];
        }
        for(int i = 0; i < n2; i++){
            ri[i] = arr[m+1+i];
        }

        int i = 0,j = 0,k=l;

        while(i < n1 && j < n2){
            if(le[i]<=ri[j]){
                arr[k] = le[i];
                i++;
            }
            else{
                arr[k] = ri[j];
                j++;
            }
            k++;
        }

        while(i < n1){
           arr[k] = le[i];
           i++;
           k++; 
        }

        while(j < n2){
            arr[k] = ri[j];
            j++;
            k++;
        }
    }

    static void sort(int[] arr, int l, int r) {
    if (l < r) {
        int m = l + (r - l) / 2;

        sort(arr, l, m);
        sort(arr, m + 1, r);

        merge(arr, l, m, r);
    }
   }

    public int findNonMinOrMax(int[] nums) {
        if(nums.length <= 2) return -1;

        sort(nums,0,nums.length-1);
        return nums[nums.length/2];
    }
}