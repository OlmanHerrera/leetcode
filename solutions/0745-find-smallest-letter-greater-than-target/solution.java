class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int codeAscii = target + 1;
        while (codeAscii <= 'z') {
            char temp = (char) codeAscii;
            if (binarySearch(letters, temp)) {
                return temp;
            }
            codeAscii++;
        }
        return letters[0];
    }

    public boolean binarySearch(char[] letters, char target) {
        int p1 = 0;
        int p2 = letters.length - 1;

        while (p1 <= p2) {
            int mid = (p1 + p2) / 2;
            if (letters[mid] == target) {
                return true;
            } else if (target < letters[mid]) {
                p2 = mid - 1;
            } else {
                p1 = mid + 1;
            }
        }
        return false;
    }
}
