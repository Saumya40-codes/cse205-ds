import java.util.Arrays;

public class selection_sort {

    private static void selection(int[] arr){
        for(int i = 0; i < arr.length-1;i++){
            int mini = i;

            for(int j = i+1; j < arr.length; j++){
                if(arr[j] < arr[mini]){
                    mini = j;
                }
            }

            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,4,5,6,1};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }
}
