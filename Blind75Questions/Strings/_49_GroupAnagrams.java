package com.mert.Blind75Questions.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
49. Group Anagrams

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
*/
public class _49_GroupAnagrams {
    public static void main(String[] args) {
        String s[] = {"eat","tea","tan","ate","nat","bat"};
        System.out.print(groupAnagrams(s));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] counts = new char[26];
            for (char c : s.toCharArray())
                counts[c - 'a']++;

            String keyStr = String.valueOf(counts);
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
