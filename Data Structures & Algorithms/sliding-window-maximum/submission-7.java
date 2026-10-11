class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int numberOfWindows = n - k + 1;
        int[] maxInWindows = new int[numberOfWindows];
        int left = 0;
        PriorityQueue<int[]> windowNums = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        for (int right = 0; right < n; right++) {
            windowNums.offer(new int[] {nums[right], right});
            if (right - left + 1 == k) {
                int windowMax = windowNums.peek()[0];
                maxInWindows[left] = windowMax;
                left++;
                while (!windowNums.isEmpty() && windowNums.peek()[1] < left) {
                    windowNums.poll();
                }
            }
        }
        return maxInWindows;
    }
}
