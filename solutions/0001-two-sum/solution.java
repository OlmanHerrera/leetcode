import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i]; // valor
            pairs[i][1] = i;       // índice original
        }
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int p1 = 0, p2 = n - 1;
        while (p1 < p2) {
            int sum = pairs[p1][0] + pairs[p2][0];
            if (sum == target) {
                return new int[]{pairs[p1][1], pairs[p2][1]};
            } else if (sum < target) {
                p1++;
            } else {
                p2--;
            }
        }
        return new int[]{-1, -1};
    }
}
