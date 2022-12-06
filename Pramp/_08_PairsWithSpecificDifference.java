package com.mert.Pramp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _08_PairsWithSpecificDifference {

    public static void main(String[] args) {
        int[] arr = { 0, -1, -2, 2, 1 };
        int k = 1;

        int[][] ans = findPairs(arr, k);

        for (int i = 0; i < ans.length; i++)
            System.out.print("["+ans[i][0] + "," + ans[i][1]+"] ");
    }

    static int[][] findPairs(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        // needed number -> exact number
        for(int i = 0; i < arr.length; i++) 
            map.put(arr[i] - k, arr[i]);

        List<int[]> ansList = new ArrayList();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i]))
                ansList.add(new int[]{map.get(arr[i]), arr[i]});
        }

        return ansList.toArray(new int[ansList.size()][2]);        
    }
}

/*
 * Given an array arr of distinct integers and a nonnegative integer k, write a
 * function
 * findPairsWithGivenDifference that returns an array of all pairs [x,y] in arr,
 * such
 * that x - y = k. If no such pairs exist, return an empty array.
 * 
 * Note: the order of the pairs in the output array should maintain the order of
 * the y element in the original array.
 * 
 * input: arr = [0, -1, -2, 2, 1], k = 1
 * output: [[1, 0], [0, -1], [-1, -2], [2, 1]]
 * 
 * input: arr = [1, 7, 5, 3, 32, 17, 12], k = 17
 * output: []
 */
