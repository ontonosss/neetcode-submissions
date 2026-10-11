class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int numberOfWindows = n - k + 1;
        int[] maxInWindows = new int[numberOfWindows];
        int left = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int right = 0; right < n; right++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            if (!deque.isEmpty() && deque.peekFirst() < left) {
                deque.pollFirst();
            }
            deque.offerLast(right);
            if (right - left + 1 == k) {
                maxInWindows[left] = nums[deque.peekFirst()];
                left++;
            }
        }
        return maxInWindows;
    }
}
