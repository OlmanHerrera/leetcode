class Solution {
    public boolean isPalindrome(int x) {
    
        String cadena = Integer.toString(x);
        int p1 = 0;
        int p2 = cadena.length()-1;
        while (p1 <= p2)
        {
            if (cadena.charAt(p1) != cadena.charAt(p2))
            {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }
}
