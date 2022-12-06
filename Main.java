package com.mert;

import com.mert.Algorithms.MergeSort;

public class Main {

    public static void main(String[] args) {
        int counts[] = { 1, 3, 5, 7, 9, 3, 4, 4, 5, 6,
                1, 3, 5, 7, 9, 3, 4, 4, 5, 6,
                1, 3, 5, 7, 9, 3, 4, 4, 5, 6,
                1, 3, 5, 20, 25, 24, 33, 5, 6, 4,
                1, 3, 5, 22, 35, 24, 32, 5, 6, 4,
                1, 3, 5, 20, 28, 34, 23, 5, 6, 4,
                1, 3, 5, 21, 25, 27, 23, 5, 6, 4,
                1, 3, 5, 7, 9, 3, 4, 4, 5, 6,
                1, 3, 5, 7, 9, 3, 4, 4, 5, 6,
                1, 3, 5, 7, 9, 3, 4, 4, 5, 6 };

        long startHistogramTime = System.nanoTime();
        histogramSort(counts);
        long stopHistogramTime = System.nanoTime();

        long startCountingTime = System.nanoTime();
        countingSort(counts);
        long stopCountingTime = System.nanoTime();

        System.out.println("Histogram: " + (stopHistogramTime - startHistogramTime));
        System.out.println("Counting: " + (stopCountingTime - startCountingTime));

        
    }

    public static void histogramSort(int[] counts) {
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                System.out.print(i + ": ");
                for (int j = 0; j < counts[i]; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    public static void countingSort(int arr[]) {
        int n = arr.length;
        int output[] = new int[n];

        int count[] = new int[256];
        for (int i = 0; i < 256; ++i)
            count[i] = 0;

        for (int i = 0; i < n; ++i)
            ++count[arr[i]];

        for (int i = 1; i <= 255; ++i)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        for (int i = 0; i < n; ++i)
            arr[i] = output[i];
    }

}
