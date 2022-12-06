package com.mert.Strings;

import java.util.Arrays;

public class PermutationString {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean flag = false;
        s1 = sort(s1);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (s1.equals(sort(s2.substring(i, i + s1.length()))))
            flag =  true;
        }
        
        System.out.println(flag);                          
    }

    public static String sort(String s) {
        char[] t = s.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }


    
}
