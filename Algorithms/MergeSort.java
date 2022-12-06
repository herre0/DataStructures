package com.mert.Algorithms;


public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {3, 1, 2, 5, 4, 8, 6, 7, 90, 45, 33, 66};

        MergeSort sorting = new MergeSort();

        sorting.sort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    public void sort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    public void merge(int[] arr, int l, int m, int r) {

        int leftArr[] = new int[m - l + 1];
        int rightArr[] = new int[r - m];

        for(int i = 0; i < leftArr.length; i++)
            leftArr[i] = arr[l + i];
        for(int i = 0; i < rightArr.length; i++)
            rightArr[i] = arr[m + 1 + i];

        int i =0, j = 0, k = l;
        while(i < leftArr.length || j < rightArr.length) {
            if (j >= rightArr.length || (i < leftArr.length && leftArr[i] < rightArr[j])) {
                arr[k++] = leftArr[i++];
            } else
                arr[k++] = rightArr[j++];
        }

    }

    public static void printArray(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
