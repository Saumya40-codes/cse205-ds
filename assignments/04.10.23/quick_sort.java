import java.util.Arrays;

public class quick_sort{

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
    public static void main(String[] args) {
        int[] arr = {9,4,5,6,1};
        quick(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}