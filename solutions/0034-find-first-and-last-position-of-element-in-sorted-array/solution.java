class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] solution = new int[2];
        solution[0] = binarySearch(nums, target,true);
        solution[1]  = binarySearch(nums,target, false);
        return solution;
    }

    public int binarySearch(int[] nums, int target, boolean first){
        int p1 = 0;
        int p2 = nums.length-1;
        int ans = -1;
        while (p1 <= p2){
            int mid = (p1+p2)/2;
            if (nums[mid] == target){
                ans = mid;
                if (first){
                    p2 = mid-1;
                }
                else{
                    p1 = mid+1;
                }
            }
            else if (target < nums[mid]){
                p2 =mid-1;
            }
            else{
                p1 = mid+1;
            }
        }
        return ans;
    }
}
