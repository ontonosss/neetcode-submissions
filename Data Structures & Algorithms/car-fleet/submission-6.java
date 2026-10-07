class Solution {
    /**

    [4, 1, 0, 7] -> [6, 3, 1, 8] -> [8, 5, 2, 9] -> [10, 7, 3, 10]
    [2, 2, 1, 1]

    [0, 5, 6, 7]
    [1, 5, 2, 1]

    [7 -> 3, 6 -> 2, 5 -> 2]

    *
  */
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (x, y) -> x[0] - y[0]);
        Deque<Double> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int[] car = cars[i];
            double time = (double) (target - car[0]) / car[1];
            if (stack.isEmpty() || stack.peek() < time) {
                stack.push(time);
            }
        }
        return stack.size();
    }
}
