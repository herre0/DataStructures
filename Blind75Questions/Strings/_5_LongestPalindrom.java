package com.mert.Blind75Questions.Strings;

/*
5. Longest Palindromic Substring

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
*/
public class _5_LongestPalindrom {
    public static void main(String[] args) {
        System.out.print(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";

        int maxLength=0;
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;

            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if(maxLength < right-left+1){
                    res = s.substring(left, right+1);
                    maxLength = res.length();
                }
                left--;
                right++;
            }
            left = i;
            right = i+1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if(maxLength < right-left+1){
                    res = s.substring(left, right+1);
                    maxLength = res.length();
                }
                left--;
                right++;
            }
        }
        return res;
    }
}
