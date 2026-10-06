class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int currentTemperature = temperatures[i];
            while (!stack.isEmpty() && currentTemperature > temperatures[stack.peek()]) {
                int previousTemperatureIndex = stack.pop();
                result[previousTemperatureIndex] = i - previousTemperatureIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
