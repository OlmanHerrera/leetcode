class Solution {
    public String longestPalindrome(String s) {
        String solution = "";
        int rightPointer;
        int leftPointer;


        for (int i = 0; i < s.length(); i++){

            // odd length
            rightPointer = leftPointer = i;
            
            while (leftPointer >= 0 && rightPointer <s.length() && s.charAt(leftPointer) == s.charAt(rightPointer)){
                if ((s.substring(leftPointer, rightPointer+1).length() > solution.length())){
                    solution = s.substring(leftPointer, rightPointer+1);
                }
                leftPointer--;
                rightPointer++;
            }
            

            // even length()

            rightPointer = i +1;
            leftPointer = i;

            while (leftPointer >= 0 && rightPointer <s.length() && s.charAt(leftPointer) == s.charAt(rightPointer)){
                if ((s.substring(leftPointer, rightPointer+1).length() > solution.length())){
                    solution = s.substring(leftPointer, rightPointer+1);
                }
                leftPointer--;
                rightPointer++;
            

    

            }
        }

        return solution;
    }
}

