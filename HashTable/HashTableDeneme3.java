package com.mert.HashTable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashTableDeneme3 {


    public static void main(String[] args) {
        String s = "10#11#12";

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                sb.append((char) (96 + Integer.valueOf(s.substring(i - 2, i))));
                i = i - 2;
            } else
                sb.append((char) (96 + (s.charAt(i) - '0')));
        }

        System.out.println(sb.reverse().toString());
    }

}
