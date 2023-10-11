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

    public int minimumSum(int num) {
        int[] arr = new int[4];

        int temp = num;
        int idx = 0;

        while(temp != 0){
            arr[idx] = temp%10;
            temp /= 10;
            idx++;
        }

        sort(arr,0,arr.length-1);
        String s1 = Integer.toString(arr[0]) + Integer.toString(arr[2]);
        String s2 = Integer.toString(arr[1]) + Integer.toString(arr[3]);

        return Integer.parseInt(s1)+Integer.parseInt(s2);
    }
}