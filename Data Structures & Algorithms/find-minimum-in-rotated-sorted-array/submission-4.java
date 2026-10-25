class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            if (nums[left] < nums[right]) {
                min = Math.min(min, nums[left]);
                break;
            }
            int mid = left + (right - left) / 2;
            min = Math.min(min, nums[mid]);
            // left sorted portion
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } 
            // right sorted portion
            else {
                right = mid - 1;
            }
        }
        return min;
    }
}
