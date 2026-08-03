class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

       // Initialize the memoization array to cache results of previously solved subproblems

        List<Boolean> dp = new ArrayList<>(Collections.nCopies(s.length()+1, false));

        // Set the base case: an empty string is always a valid segmentation
        dp.set(s.length(), true);

        // Loop backwards from the end of the string to the beginning
        for (int i = s.length(); i >= 0; i--) {
            for (String word : wordDict){
                if (i+ word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)){
                    dp.set(i, dp.get(i+word.length()));
                }
                if (dp.get(i)){
                    break;
                    }
            }
        }

        // The final result is stored at the beginning of the DP table
        return dp.get(0);



        
    }
}
