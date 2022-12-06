package com.mert.Algorithms;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 7, 8, 9, 6, 4, 1};

        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

        printArray(arr);
    }

    private static void printArray(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
