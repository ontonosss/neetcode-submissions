class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < cars.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (x, y) -> y[0] - x[0]);
        int carFleets = 0;
        double maxTime = 0;
        for (int[] car: cars) {
            double time = (double) (target - car[0]) / car[1];
            if (time > maxTime) {
                carFleets++;
                maxTime = Math.max(maxTime, time);
            }
        }
        return carFleets;
    }
}
