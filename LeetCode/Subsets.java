package com.mert.LeetCode;

import java.util.*;

public class Subsets {


    static List<List<Integer>> result = new ArrayList();

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        
        subsets(nums, new ArrayList<Integer>(), 0);


        System.out.println(result);
    }


    private static void subsets(int[] nums, ArrayList<Integer> temp, int index) {
        // base condition
        if(index >= nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        // main logic
		// case 1 : we pick the element
        temp.add(nums[index]);
        subsets(nums, temp, index+1); // move ahead
        temp.remove(temp.size()-1);
        
		// case 2 : we don't pick the element ( notice, we did not add the current element in our temporary list
        subsets(nums, temp, index+1); // move ahead
    }
    
}
