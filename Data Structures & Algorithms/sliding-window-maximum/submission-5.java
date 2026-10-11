class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int numberOfWindows = n - k + 1;
        int[] maxInWindows = new int[numberOfWindows];
        int left = 0;
        PriorityQueue<Integer> windowNums = new PriorityQueue<>((x, y) -> y - x);
        for (int right = 0; right < n; right++) {
            windowNums.offer(nums[right]);
            if (right - left + 1 == k) {
                int windowMax = windowNums.peek();
                windowNums.remove(nums[left]);
                maxInWindows[left] = windowMax;
                left++;
            }
        }
        return maxInWindows;
    }
}
