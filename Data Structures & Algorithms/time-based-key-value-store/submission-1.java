class TimeMap {

    Map<String, TreeMap<Integer, String>> storage = new HashMap<>();

    public void set(String key, String value, int timestamp) {
        storage.computeIfAbsent(key, k -> new TreeMap<>())
            .put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timeStorage = storage.get(key);
        if (timeStorage == null) {
            return "";
        }
        Map.Entry<Integer, String> entry = timeStorage.floorEntry(timestamp);
        return entry == null 
            ? "" 
            : entry.getValue(); 
    }
}
