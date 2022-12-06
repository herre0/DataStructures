package com.mert.Blind75Questions.Strings;

/*
424. Longest Repeating Character Replacement

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
*/
public class _424_LongestRepeatingChar {
    public static void main(String[] args) {
        System.out.print(characterReplacement("ABAB", 2));
    }

    public static int characterReplacement(String s, int k) {
        int counts[] = new int[26];

        int left = 0;
        int maxCount = 0, maxLength = 0;
        for(int right = 0; right < s.length(); right++) {
            maxCount = Math.max(maxCount, ++counts[s.charAt(right) - 'A']);

            while(right-left + 1 - maxCount > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right-left+1);
        }

        return maxLength;
    }
}
