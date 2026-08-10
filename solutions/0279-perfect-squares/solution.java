class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        int square;
        dp[0] = 0;

        for (int i = 1; i <= n; i++){
            dp[i] = n;
        }

        for (int i = 1; i <= n; i++){
            for (int s = 1; s <= i; s++ ){
                square = s*s; 
                if (i-square < 0){
                    break;
                }
                dp[i] = Math.min(dp[i], 1 +  dp[i-square]);

            }
        
        }

        return dp[n];
    }
}
