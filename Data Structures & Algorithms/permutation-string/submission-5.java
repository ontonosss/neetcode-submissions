class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int s1CharsNeeded = 0;
        int[] s1Chars = new int[26];
        for (char ch: s1.toCharArray()) {
            int chNumber = ch - 'a';
            s1Chars[chNumber]++;
            if (s1Chars[chNumber] == 1) {
                s1CharsNeeded++;
            }
        }

        int s2CharsMatches = 0;
        int[] s2Chars = new int[26];
        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            int inCh = s2.charAt(right) - 'a';
            if (s2Chars[inCh] == s1Chars[inCh]) {
                s2CharsMatches--;
            }
            s2Chars[inCh]++;
            if (s2Chars[inCh] == s1Chars[inCh]) {
                s2CharsMatches++;
            }
            if (right - left + 1 == s1.length()) {
                if (s1CharsNeeded == s2CharsMatches) {
                    return true;
                }
                int outCh = s2.charAt(left) - 'a';
                if (s2Chars[outCh] == s1Chars[outCh]) {
                    s2CharsMatches--;
                }
                s2Chars[outCh]--;
                if (s2Chars[outCh] == s1Chars[outCh]) {
                    s2CharsMatches++;
                }
                left++;
            }
        }
        return false;
    }
}
