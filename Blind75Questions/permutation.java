package com.mert.Blind75Questions;

import java.util.*;

public class permutation {

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList();
        int[] nums = {1, 2, 3};

        backtrack(result, new ArrayList(), nums);

        System.out.println(result);
    }

    public static void backtrack(List<List<Integer>> list, List<Integer> subList, int [] nums){
        if (subList.size() == nums.length)
            list.add(new ArrayList<>(subList));
         else {             
            for(int i = 0; i < nums.length; i++){ 
               if(subList.contains(nums[i])) 
                   continue; // element already exists, skip
                
               subList.add(nums[i]);
               backtrack(list, subList, nums);
               subList.remove(subList.size() - 1);
            }
         }
   }
    
}
