class Solution {

    private static int partition(int[] arr,int low,int high){
        int pivot = arr[low];
        int i = low;
        int j = high;

        while(i < j){
            while(i <= high && arr[i] <= pivot){
                i++;
            }

            while(j >= 0 && arr[j] > pivot){
                j--;
            }

            if(i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;     

        return j;   
    }
    private static void quick(int[] arr,int low, int high){
        if(low < high){
            int pIndex = partition(arr,low,high);
            quick(arr,low,pIndex-1);
            quick(arr,pIndex+1,high);
        }
    }
    public int majorityElement(int[] nums) {
        quick(nums,0,nums.length-1);
        return nums[nums.length/2];
    }
}