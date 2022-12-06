package com.mert.LeetCode;
/*
* https://leetcode.com/problems/maximum-subarray/
* finding maximum subarray
*
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
*
* */


public class MergeSort {


    public static void main(String[] args) {
        int nums[] = {5,4,-1,7,8};

        MergeSort mergeSort = new MergeSort();

        System.out.println(mergeSort.maxSubArray(nums, 0, nums.length - 1));
    }

    private int maxSubArray(int[] nums, int l, int r) {
        if (l == r)
            return nums[l];
        //divide
        int m = (r + l) / 2;
        //conquer
        int leftSum = maxSubArray(nums, l, m);
        int rightSum = maxSubArray(nums, m + 1, r);
        //combine
        int crossSum = crossSum(nums, l, r);

        return Math.max(crossSum, Math.max(leftSum, rightSum));
    }

    private int crossSum(int[] nums, int l, int r) {
        int m = (l + r) / 2;

        int leftMax= Integer.MIN_VALUE, leftSum = 0;
        for(int i = m; i >= l; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftSum, leftMax);
        }
        int rightMax =0, rightSum = 0;
        for(int i = m+1; i <= r; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightMax, rightSum);
        }

        return leftMax + rightMax;
    }


}
