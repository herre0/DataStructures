package com.mert.Algorithms;

public class SelectionSort {

    public static void main(String[] args) {
        int[] numbers = {5, 3, 2, 7, 8, 9, 6, 4, 1};
        int min, temp;
        for (int i = 0; i < numbers.length; i++) {
            min = i;

            for(int j = i; j < numbers.length; j++) {
                if(numbers[min] > numbers[j])
                    min = j;
            }
            temp = numbers[i];
            numbers[i] = numbers[min];
            numbers[min] = temp;
        }

        printArray(numbers);
    }

    private static void printArray(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
