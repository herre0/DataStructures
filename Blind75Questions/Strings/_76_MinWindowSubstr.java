package com.mert.Blind75Questions.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
76. Minimum Window Substring

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
*/
public class _76_MinWindowSubstr {
    public static void main(String[] args) {
        //System.out.print(minWindow("ADOBECODEBANC", "ABC"));

        System.out.print(shortestRoute("aabcce"));
    }

    public static String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0)
            return "";

        HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        for(char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);


        int left = 0;
        int minLeft = 0;
        int minLen = s.length()+1;
        int count = 0;

        for(int right = 0; right < s.length(); right++){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),map.get(s.charAt(right))-1);
                if(map.get(s.charAt(right)) >= 0)
                    count++;

                while(count == t.length()){
                    if(right-left+1 < minLen){
                        minLeft = left;
                        minLen = right-left+1;
                    }
                    if(map.containsKey(s.charAt(left))){
                        map.put(s.charAt(left),map.get(s.charAt(left))+1);
                        if(map.get(s.charAt(left)) > 0)
                            count--;
                    }
                    left ++ ;
                }
            }
        }

        if(minLen>s.length())
            return "";


        return s.substring(minLeft,minLeft+minLen);
    }

    public static int shortestRoute(String route) {         
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < route.length(); i++){
            if(!map.containsKey(route.charAt(i))){
                map.put(route.charAt(i), 1);
            }
        }        
       
        int left = 0;
        int minLen = route.length()+1;
        int minLeft = 0;
        Set<Character> hadList = new HashSet<>();
        for(int right = 0; right < route.length(); right++) {
            if(map.containsKey(route.charAt(right))){
                hadList.add(route.charAt(right));
                
                while(hadList.size() == map.size()) {
                    if(right-left+1 < minLen){
                        minLeft = left;
                        minLen = right-left+1;
                    }
                    if(hadList.contains(route.charAt(left))){
                        hadList.remove(new Character(route.charAt(left)));
                        right = left;
                    }
                    
                    left++;
                }
            }
        }              
        
        return minLen;
    }


    public static int shortestRoute2(String route) {            
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < route.length(); i++){
            if(!map.containsKey(route.charAt(i))){
                map.put(route.charAt(i), 1);
            }
        }        
       
        int left = 0;
        int minLen = route.length()+1;
        int minLeft = 0;
        int count = 0;
        for(int right = 0; right < route.length(); right++){
            if(map.containsKey(route.charAt(right))){
                if(map.get(route.charAt(right)) > 0){
                    map.put(route.charAt(right),map.get(route.charAt(right))-1);                
                    count++;
                }                

                while(count == map.size() && left < right){
                    if(right-left+1 < minLen){
                        minLeft = left;
                        minLen = right-left+1;
                    }               
                    
                    left ++ ;
                }
            }
        }         
        
        return minLen;
    }
}
