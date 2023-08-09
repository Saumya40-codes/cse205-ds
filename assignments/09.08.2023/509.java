//using recursion

class Solution {
    private static int fibo(int n){
        if(n == 0 || n == 1){
            return n;
        }

        return fibo(n-1) + fibo(n-2);
    }
    public int fib(int n) {
        return fibo(n);
    }
}


// usinf dp (memoization)

class Solution {
    private static int fibo(int n, int[] dp){
        if(n == 0 || n == 1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }

        dp[n] = fibo(n-1,dp) + fibo(n-2,dp);
        return dp[n];
    }
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return fibo(n, dp);
    }
}