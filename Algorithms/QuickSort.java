package com.mert.Algorithms;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 7, 8, 9, 6, 4, 1};
        int n = arr.length;
        quickSort(arr, 0, n - 1);

       printArray(arr);
    }

    static int partition(int[] arr, int low, int high) {
        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++) {
            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] numbers) {
        for(int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");
    }
}
