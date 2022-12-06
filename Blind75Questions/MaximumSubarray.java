package com.mert.Blind75Questions;
/*https://leetcode.com/problems/maximum-subarray/*/

public class MaximumSubarray {

    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};

        MaximumSubarray ms = new MaximumSubarray();

        int sum = ms.maxSubArray(arr, 0, arr.length - 1);
        System.out.print(sum);
    }

    public int maxSubArray(int[] nums, int l, int r){
        if(l == r)
            return nums[l];

        int m = (l+r) /2;

        int leftSum = maxSubArray(nums, l, m);
        int rightSum = maxSubArray(nums, m+1, r);

        int crossSum = crossSum(nums, l, m, r);

        return Math.max(crossSum, Math.max(leftSum, rightSum));
    }

    public int crossSum(int[] nums, int l, int m, int r) {
        int leftSum=0, leftMax = Integer.MIN_VALUE;
        for(int i = m; i >= l; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftSum, leftMax);
        }
        int rightSum=0, rightMax = Integer.MIN_VALUE;
        for(int i = m+1; i <= r; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightSum, rightMax);
        }

        return rightMax + leftMax;
    }
}
