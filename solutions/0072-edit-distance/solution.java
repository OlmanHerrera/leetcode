class Solution {
    public int minDistance(String word1, String word2) {
                List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= word1.length(); i++) {
        
            List<Integer> fila = new ArrayList<>(Collections.nCopies(word2.length() + 1, -1));
            dp.add(fila);
        }
        

        for (int j = word2.length(); j >= 0; j--) {
            dp.get(word1.length()).set(j, word2.length() - j);
        }
        
      
        for (int i = word1.length(); i >= 0; i--) {
            dp.get(i).set(word2.length(), word1.length() - i);
        }

        for (int i = word1.length() - 1; i >= 0; i--) {
            for (int j = word2.length() - 1; j >= 0; j--) {
              
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp.get(i).set(j, dp.get(i + 1).get(j + 1));
                }
                else {
                    dp.get(i).set(j, 1 + Math.min(dp.get(i).get(j + 1), Math.min(dp.get(i + 1).get(j), dp.get(i + 1).get(j + 1))));
                }
            } 
        }
        
        return dp.get(0).get(0);
    
    }
}
