class Solution {
    private static boolean pow(int n){
        if(n == 1){
            return true;
        }

        if(n % 2 != 0){
            return false;
        }
        return pow(n/2);
    }
    public boolean isPowerOfTwo(int n) {
        if(n == 0){
            return false;
        }
        return pow(n);

        // bit manip
        // if(n <= 0){
        //     return false;
        // }
        // else {
        //     return (n&(n-1)) == 0;
        // }
    }
} 
