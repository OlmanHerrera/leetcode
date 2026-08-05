class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        dp[0][0] = 0;
        for (int i = 1; i <= s1.length(); i++ ){
            dp[i][0] = (int) s1.charAt(i-1) + dp[i-1][0];
        }
        for (int j = 1; j <= s2.length(); j++ ){
            dp[0][j] = (int) s2.charAt(j-1) + dp[0][j-1];
        }

        for (int i = 1; i<= s1.length(); i++){
            for (int j = 1; j<= s2.length(); j++){
                if (s1.charAt(i-1)==(s2.charAt(j-1))){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int delete_s1 = (int) s1.charAt(i-1) + dp[i-1][j];
                    int delete_s2 = (int) s2.charAt(j-1) + dp[i][j-1];

                    dp[i][j] = Math.min(delete_s1,delete_s2);
                }
            }
        }
        
        return dp[s1.length()][s2.length()];
    }
}

