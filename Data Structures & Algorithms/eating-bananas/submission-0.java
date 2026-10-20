class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = findMaxSpeed(piles);
        int minSpeed = right;
        while (left <= right) {
            int currentSpeed = left + (right - left) / 2;
            if (calculateHoursNeeded(piles, currentSpeed) <= h) {
                right = currentSpeed - 1;
                minSpeed = currentSpeed;
            } else {
                left = currentSpeed + 1;
            }
        }
        return minSpeed;
    }

    private int findMaxSpeed(int[] piles) {
        int maxSpeed = 0;
        for (int pile: piles) {
            maxSpeed = Math.max(maxSpeed, pile);
        }
        return maxSpeed;
    }

    private long calculateHoursNeeded(int[] piles, int speed) {
        long hoursNeeded = 0;
        for (int pile: piles) {
            hoursNeeded += Math.ceil((double) pile / speed);
        }
        return hoursNeeded;
    }
}