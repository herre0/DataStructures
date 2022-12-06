package com.mert.Pramp;

import java.util.PriorityQueue;
import java.util.Deque;

public class _02_K_MessedArraySort {

    public static void main(String[] args) {
        int arr[] = { 2, 1, 4, 5, 3, 7, 8, 6, 10, 9 };
        int k = 2;        

        slidingWindowImpl(arr, k);

        // print the sorted array
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        

    }
    // time: O(nlogk) | space: O(k)
    public static void minHeapImpl(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();        
        
        // build heap [1, 4, 5]
        for (int i = 0; i <= k; i++) 
            minHeap.add(arr[i]);        

        int counter = 0;
        for (int i = k + 1; i < arr.length; i++) {
            int min = minHeap.poll(); 
            arr[counter++] = min;
            minHeap.add(arr[i]);
        }

        // put the rest into array
        while (!minHeap.isEmpty()) {
            arr[counter++] = minHeap.poll();
        }
    }
    // time: O(nk) | space: O(1)
    public static void slidingWindowImpl(int[] arr, int k) {
        for(int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for(int j = i; j <= i + k && j < arr.length; j++){
                if(arr[j] < arr[minIndex])
                    minIndex = j;                
            }

            // swap i and minIndex
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    /*                                |
      [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
     i                         ^  
     j                             ^     
     min: 0(index)
     */

}


/*
  K-Messed Array Sort
Given an array of integers arr where each element is at most k places away from its sorted position,
 code an efficient function sortKMessedArray that sorts arr. For instance, for an input array of size 10 
 and k = 2, an element belonging to index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.

Analyze the time and space complexities of your solution.

input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2

output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 
 */