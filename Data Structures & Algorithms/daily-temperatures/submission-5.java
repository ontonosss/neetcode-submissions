class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int currentTemperature = temperatures[i];
            while (!stack.isEmpty() && currentTemperature > stack.peek()[1]) {
                int previousTemperatureIndex = stack.pop()[0];
                result[previousTemperatureIndex] = i - previousTemperatureIndex;
            }
            stack.push(new int[]{i, currentTemperature});
        }
        return result;
    }
}
