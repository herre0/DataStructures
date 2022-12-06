package com.mert.Pramp;

import java.util.*;

public class _12_FindDuplicates {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 6, 7};
        int[] arr2 = {3, 6, 7, 8, 20};

        int[] ans = findDuplicates(arr1, arr2);
        
        for(int i: ans)
            System.out.print(i + " ");
    }

    public static int[] findDuplicates(int[] arr1, int[] arr2) {

        List<Integer> ans = new ArrayList();
        int l = 0, r = 0;
        while(l < arr1.length && r < arr2.length) {
            if(arr1[l] == arr2[r]){
                ans.add(arr1[l]);
                l++;
                r++;
            } else if (arr1[l] < arr2[r])
                l++;
            else
                r++;                
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
             res[i] = ans.get(i);

        return res;
    }


}
