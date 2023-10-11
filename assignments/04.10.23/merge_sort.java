import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class merge_sort {

    private static void sort(int[] arr, int low, int high, int mid){
        int left = low;
        int right = mid+1;
        List<Integer> lst = new ArrayList<>();

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                lst.add(arr[left]);
                left++;
            }
            else{
                lst.add(arr[right]);
                right++;
            }
        }

        while(left <= mid){
            lst.add(arr[left]);
            left++;
        }
        while(right <= high){
            lst.add(arr[right]);
            right++;
        }

        for(int i = low; i <= high; i++){
            arr[i] = lst.get(i-low);
        }
    }

    private static void merge(int[] arr, int low, int high){
        if(low >= high) return;

        int mid = (low+high)/2;
        merge(arr, low, mid);
        merge(arr, mid+1, high);
        sort(arr, low, high, mid);
    }
    public static void main(String[] args) {
        int[] arr = {2,4,5,6,1};
        merge(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
