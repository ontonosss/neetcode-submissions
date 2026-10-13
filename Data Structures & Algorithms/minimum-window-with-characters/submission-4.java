class Solution {

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int minWindowStartIndex = -1;
        int minWindowLength = Integer.MAX_VALUE;
        int[] requiredCharOccurrences = new int[64];
        int requiredCharOccurrencesToMatch = 0;
        for (int i = 0; i < t.length(); i++) {
            int chCode = t.charAt(i) - 'A';
            requiredCharOccurrences[chCode]++;
            if (requiredCharOccurrences[chCode] == 1) {
                requiredCharOccurrencesToMatch++;
            }
        }
        int[] windowCharOccurrences = new int[64];
        int windowCharOccurrencesToMatch = 0;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            int inChCode = s.charAt(right) - 'A';
            windowCharOccurrences[inChCode]++;
            if (windowCharOccurrences[inChCode] == requiredCharOccurrences[inChCode]) {
                windowCharOccurrencesToMatch++;
            }
            if (windowCharOccurrencesToMatch != requiredCharOccurrencesToMatch) {
                continue;
            }
            // substring contains t, trying to shrink
            while (left <= right) {
                int currentWindowLength = right - left + 1;
                if (currentWindowLength < minWindowLength) {
                    minWindowLength = currentWindowLength;
                    minWindowStartIndex = left;
                }
                int outChCode = s.charAt(left) - 'A';
                windowCharOccurrences[outChCode]--;
                left++;
                if (windowCharOccurrences[outChCode] < requiredCharOccurrences[outChCode]) {
                    windowCharOccurrencesToMatch--;
                    break;
                }
            }
        }
        return minWindowStartIndex == -1
            ? ""
            : s.substring(minWindowStartIndex, minWindowStartIndex + minWindowLength);
    }
}
