package com.mert.Blind75Questions.Strings;

/*
125. Valid Palindrome

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
*/
public class _125_ValidPalindrome {
    public static void main(String[] args) {
        System.out.print(isPalindrome( "A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {

        String text = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        String reverse = "";
        for(int i = text.length()-1; i >= 0; i--) {
            reverse += String.valueOf(text.charAt(i));
        }

        return reverse.equals(text);
    }
}
