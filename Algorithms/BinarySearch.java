package com.mert.Algorithms;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int target = 6;

        int result = bs.binarySearch(arr, 0, arr.length - 1, target);
        if (result == -1)
            System.out.print("It's not present in the arr");
         else
            System.out.print("Found at " + result);

    }

    public int binarySearch(int arr[], int l, int r, int target) {
        if (l <= r) {
            int m = (l + r) / 2;

            if (arr[m] == target)
                return m;

            if (arr[m] > target)
                return binarySearch(arr, l, m - 1, target);
            else
                return binarySearch(arr, m + 1, r, target);
        }
        return -1;
    }

}
