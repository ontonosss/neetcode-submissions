class TimeMap {

    Map<String, List<Pair>> storage = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        storage.computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> timeStorage = storage.get(key);
        if (timeStorage == null) {
            return "";
        }
        int closest = findClosest(timeStorage, timestamp);
        return closest == -1
            ? ""
            : timeStorage.get(closest).value();
    }

    private int findClosest(List<Pair> pairs, int timestamp) {
        int left = 0, right = pairs.size() - 1;
        int closest = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (pairs.get(mid).timestamp() == timestamp) {
                closest = mid;
                break;
            }
            if (pairs.get(mid).timestamp() < timestamp) {
                closest = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return closest;
    }

    record Pair(int timestamp, String value) {
    }
}
