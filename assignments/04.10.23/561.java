class Solution {

    private static int sort(int[] arr, int low, int high){
    int pivot = arr[low];
    int i = low;
    int j = high;

    while(i < j){
        while(i <= high && arr[i] <= pivot){
            i++;
        }
        while(j >= low && arr[j] > pivot){
            j--;
        }

        if(i < j){
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

private static void quick(int[] arr, int low, int high){
    if(low < high){
        int pIndex = sort(arr,low,high);
        quick(arr, low, pIndex-1);
        quick(arr, pIndex+1, high);
    }
}

public int arrayPairSum(int[] nums) {
quick(nums, 0, nums.length - 1);

int sum = 0;

for (int i = 0; i < nums.length; i += 2) {
    sum += nums[i];
}

return sum;
}
}