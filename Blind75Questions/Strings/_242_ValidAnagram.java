package com.mert.Blind75Questions.Strings;

import java.util.HashMap;

/*
242. Valid Anagram

Input: s = "anagram", t = "nagaram"
Output: true
*/
public class _242_ValidAnagram {
    public static void main(String[] args) {
        System.out.print(isAnagram( "anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        HashMap<Character, Integer> map = new HashMap();

        for(char c : s.toCharArray()) {
            int count = map.getOrDefault(c, 0)+1;
            map.put(c, count);
        }

        for(char c : t.toCharArray()) {
            int newCount = map.getOrDefault(c, 0)-1;
            if(newCount < 0)
                return false;
            map.put(c, newCount);
        }

        return true;
    }
}
