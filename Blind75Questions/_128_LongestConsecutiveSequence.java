package com.mert.Blind75Questions;
/*https://leetcode.com/problems/longest-consecutive-sequence/*/


import java.util.*;

public class _128_LongestConsecutiveSequence {

    public static void main(String[] args) {
        int nums[] = {100, 4, 200, 1, 3, 2};

        System.out.print(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet set = new HashSet<>();
        for(int i : nums)
            set.add(i);

        int max = 0;
        for(int i : nums){
            if(!set.contains(i-1)){
                int count = i;
                while(set.contains(count)){
                    count++;
                }
                max = Math.max(count - i, max);
            }
        }
        return max;
    }
}
