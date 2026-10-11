class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Deque<Integer> barsToProcess = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            int height = (i == n) ? 0 : heights[i];
            while (!barsToProcess.isEmpty() && heights[barsToProcess.peek()] > height) {
                int areaHeight = heights[barsToProcess.pop()];
                int leftBar = barsToProcess.isEmpty() 
                    ? -1 
                    : barsToProcess.peek();
                int rightBar = i;
                int area = (rightBar - leftBar - 1) * areaHeight;
                maxArea = Math.max(maxArea, area);
            }
            barsToProcess.push(i);
        }
        return maxArea;
    }


}
