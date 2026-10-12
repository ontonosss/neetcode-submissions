class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // if s1.length > s2.length -> false
        if (s1.length() > s2.length()) {
            return false;
        }
        // init s1 occurences -> o(N)
        int[] s1Chars = new int[26];
        for (char ch: s1.toCharArray()) {
            s1Chars[ch - 'a']++;
        }

        int[] s2Chars = new int[26];
        // fixed sliding window
        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            char inCh = s2.charAt(right);
            s2Chars[inCh - 'a']++;
            // track occurences of chars in window O(M)
            if (right - left + 1 == s1.length()) {
                boolean matches = true;
                // if within window occurences of chars = s1 occurences in chars -> true
                for (int i = 0; i < 26; i++) {
                    matches &= s1Chars[i] == s2Chars[i];
                }
                if (matches) {
                    return true;
                }
                char outCh = s2.charAt(left);
                s2Chars[outCh - 'a']--;
                left++;
            }
        }
        return false;
    }
}
