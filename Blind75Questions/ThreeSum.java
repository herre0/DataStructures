package com.mert.Blind75Questions;
/*https://leetcode.com/problems/3sum/*/


import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int nums[] = {-1,0,1,2,-1,-4};

        print2DList(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int j, k;
        Set<List<Integer>> ansList = new HashSet();
        Arrays.sort(nums);

        for(int i =0; i < nums.length-2; i++){
            j = i+1;
            k = nums.length-1;

            while(j < k) {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0){
                    ansList.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                } else if(sum > 0) k--;
                else if(sum < 0) j++;
            }
        }

        return new ArrayList<>(ansList);
    }

    public static void print2DList(List<List<Integer>> list) {
        for(List l : list){
            System.out.print("[");
            for(int i = 0; i < l.size(); i++){
                if(i + 1 >= l.size())
                    System.out.print(l.get(i));
                else
                    System.out.print(l.get(i)+", ");
            }
            System.out.print("]");
        }
    }

}
