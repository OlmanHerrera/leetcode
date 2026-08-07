class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if  (cost == null || cost.length == 0){
            return 0;
        }
        if (cost.length == 1){
            return cost[0];
        }
        if (cost.length == 2){
            return Math.min(cost[0], cost[1]);
        }

        int[] dp = new int[cost.length + 2]; 
        dp[cost.length+1] = 0;
        dp[cost.length] = 0;

        for(int i = cost.length-1; i >= 0 ; i--){
            dp[i] = Math.min(dp[i+1]+cost[i], dp[i+2]+cost[i]);
        } 

        return Math.min(dp[0], dp[1]);
        


        
    }
}
