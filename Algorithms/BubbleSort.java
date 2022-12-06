package com.mert.Algorithms;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 7, 8, 9, 6, 4, 1};
        int temp;
        for (int i = 0; i <  arr.length-1; i++)

            for(int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]){ //swapping
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        printArray(arr);
    }

    private static void printArray(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
