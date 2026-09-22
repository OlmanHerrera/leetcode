class Solution {
    public int coinChange(int[] coins, int amount) {
        Float[] dp = new Float[amount + 1];
        dp[0] = 0f;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Float.POSITIVE_INFINITY;
        }

        for (int c : coins) {
            for (int j = c; j <= amount; j++) {
                dp[j] = Math.min(dp[j], 1 + dp[j - c]);
            }
        }

        if (dp[amount] == Float.POSITIVE_INFINITY) {
            return -1;
        }
        return dp[amount].intValue();
    }
}
