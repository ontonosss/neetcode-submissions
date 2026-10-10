class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> barsToProcess = new ArrayDeque<>();
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            int height = (i == n) ? 0 : heights[i];
            while (!barsToProcess.isEmpty() && heights[barsToProcess.peek()] > height) {
                int topHeight = heights[barsToProcess.pop()];
                int rightWall = i;
                int leftWall = barsToProcess.isEmpty() ? -1 : barsToProcess.peek();
                int width = rightWall - leftWall - 1;
                maxArea = Math.max(maxArea, topHeight * width);
            }
            barsToProcess.push(i);
        }
        return maxArea;
    }
}