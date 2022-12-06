package com.mert.Pramp;

import java.util.Arrays;

public class _11_DeletionDistance {
    public static void main(String[] args) {
        String str1 = "dog", str2 ="frog";
        int memo[][] = new int[str1.length()+1][str2.length()+1];
        for(int[] r: memo)
            Arrays.fill(r, -1);
        System.out.println(deleteDistance(0, 0, str1, str2, memo));
    }

    public static int deleteDistance(int i, int j, String str1, String str2, int[][] memo) {
        if(i >= str1.length())
            return str2.substring(j).length();
        if(j >= str2.length())
            return str1.substring(i).length();

        if(memo[i][j] != -1)
            return memo[i][j];

        if(str1.charAt(i) == str2.charAt(j))
            memo[i][j] = deleteDistance(i+1, j+1, str1, str2, memo);
        else
            memo[i][j] = Math.min(deleteDistance(i+1, j, str1, str2, memo), deleteDistance(i, j+1, str1, str2, memo)) + 1;
        
        return memo[i][j];
    }
}
