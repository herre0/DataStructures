package com.mert.Blind75Questions.Strings;

/*
647. Palindromic Substrings

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
*/
public class _647_PalindromicSubstrings {
    public static void main(String[] args) {
        System.out.print(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        int l, r, res=0;
        for(int i = 0; i < s.length(); i++) {
            l = i;
            r = i;

            while(l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                r++;
                l--;
                res++;
            }

            l = i;
            r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r) ){
                res++;
                l--;
                r++;
            }

        }

        return res;
    }
}
