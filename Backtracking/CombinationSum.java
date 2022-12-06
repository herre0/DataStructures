package com.mert.Backtracking;

import java.util.*;

public class CombinationSum {

    public static void main(String[] args){

        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        System.out.println(list);
    }

    public static void backtrack(List<List<Integer>> ansList, List<Integer> tempList, int [] nums, int remaining, int start){
        if(remaining < 0) 
            return;
        else if(remaining == 0) 
            ansList.add(new ArrayList(tempList));
        else{ 
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(ansList, tempList, nums, remaining - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
   }
    
}
