class Solution {


    // 1, 0, 2, 2, 0
    // red: 1
    // blue: 3

    /**
    0, 1, 2, 2, 0
    0, 1, 0, 2, 2
    **/

    public void sortColors(int[] nums) {
        int redIndex = 0; // red region
        int blueIndex = nums.length - 1; // blue region
        int i = 0;
        while (i <= blueIndex) {
            int color = nums[i];
            if (color == 0) {
                swap(nums, redIndex, i);
                redIndex++;
                i++;
            } else if (color == 2) {
                swap(nums, blueIndex, i);
                blueIndex--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}