package com.mert.Pramp;

import java.util.Arrays;
import java.util.Comparator;

/*
 Absolute Value Sort
Given an array of integers arr, write a function absSort(arr), that sorts the array
 according to the absolute values of the numbers in arr. 
 If two numbers have the same absolute value, sort them according to sign, 
 where the negative numbers come before the positive numbers.
 Examples:

input:  arr = [2, -7, -2, -2, 0]
output: [0, -2, -2, 2, -7]
 */

public class _05_AbsoluteValueSort {


    public static void main(String[] args) {
        Integer arr[] = {2, -7, -2, -2, 0};

        Comparator comparator = new Comparator<Integer>(){
            @Override
            public int compare(Integer n1, Integer n2) {
                if(Math.abs(n1) == Math.abs(n2))
                    return n1.compareTo(n2);
                
                return Math.abs(n1) - Math.abs(n2);
            }
        };

        Arrays.sort(arr, comparator);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
            
    }
    
}
