package com.mert.Algorithms;

public class LinearSearch {

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 7, 8, 9, 6, 4, 1};
        int target = 9;
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] == target) {
                System.out.print("Index = " + i + " target = " + target);
            }
    }

}
