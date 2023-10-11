import java.util.Arrays;

public class insertion_sort {

    private static void insertion(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int j = i;

            while(j >0 && arr[j-1] > arr[j]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,4,5,6,1};
        insertion(arr);
        System.out.println(Arrays.toString(arr));
    }
}
