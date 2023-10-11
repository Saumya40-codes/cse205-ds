class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int len = 0;

        for(int i = 0; i < arr1.length; i++){
            len = arr1[i] > len?arr1[i]:len;
        }
        
        int[] store = new int[len+1];

        for(int num1:arr1){
            store[num1]++;
        }

        int idx = 0;

        for(int num2:arr2){
            while(store[num2]-- > 0){
                arr1[idx++] = num2; 
            }
        }

        for(int i = 0; i < store.length; i++){
            while(store[i]-- > 0){
                arr1[idx++] = i;
            }
        }

        return arr1;
    }
}