class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int min = 0;
        // find min index to determine # of rotations
        while (left <= right) {
            if (nums[left] < nums[right]) {
                if (nums[left] < nums[min]) {
                    min = left;
                } 
                break;
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[min]) {
                min = mid;
            }
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // BS with rotations
        int numberOfRotations = min;
        left = 0; 
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int rotatedMid = (mid + numberOfRotations) % nums.length;
            if (nums[rotatedMid] == target) {
                return rotatedMid;
            }
            if (nums[rotatedMid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // can be refactored to different methods, but kept simple for now
        return -1;
    }
}
