package com.mert.Blind75Questions.Strings;

import java.util.HashSet;
import java.util.Set;

/* 3. Longest Substring Without Repeating Characters
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
*/
public class _3_LongestSubstring {
    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        Set<Character> hashSet = new HashSet();

        while(j < s.length()){
            if(!hashSet.contains(s.charAt(j))){
                hashSet.add(s.charAt(j));
                j++;
                max = Math.max(max, hashSet.size());
            } else {
                hashSet.remove(s.charAt(i));
                i++;
            }
        }

        return max;
    }
}
