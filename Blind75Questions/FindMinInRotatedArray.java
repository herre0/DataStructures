package com.mert.Blind75Questions;
/*https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/discuss/48487/Java-solution-with-binary-search*/
/* uses binary search O(logn)*/

public class FindMinInRotatedArray {

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4};

        System.out.print(findMin(nums));
    }

    public static int findMin(int[] num) {
        int start = 0, end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && num[mid] < num[mid - 1])
                return num[mid];

            if (num[start] <= num[mid] && num[mid] > num[end])
                start = mid + 1;
            else
                end = mid - 1;

        }
        return num[start];
    }


}
