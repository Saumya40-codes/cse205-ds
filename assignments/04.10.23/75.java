class Solution {

    private static void sort(int[] arr, int len){
            int low = 0, mid = 0, high = len -1;

            while(mid <= high){
                if(arr[mid] == 0){
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;

                    low++;
                    mid++;
                }
                else if(arr[mid] == 1){
                    mid++;
                }
                else{
                    int temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                }
            }
        }

    public void sortColors(int[] nums) {
        sort(nums,nums.length);
    }
}


// 0 then swap  mid <-> low then (low+1)
// 1 then continue
// 2 swap from mid <-> high then (high-1)

// mid passes high && array is sorted

/* DNF 
0 to low-1 -> 0
low to mid-1 -> 1
mid to high -> unsorted part
high+1 to n-1 -> 2
*/