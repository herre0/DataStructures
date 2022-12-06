package com.mert.Blind75Questions;
/*https://leetcode.com/problems/merge-intervals/*/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56_MergeIntervals {

    public static void main(String[] args) {
        int intervals[][] = {{1,3}, {2,6}, {8, 6},{15, 18}};

        print2DArray(4, 2, merge(intervals));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {                             // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void print2DArray(int r, int c, int[][] matrx) {
        for (int i = 0; i < matrx.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrx[0].length; j++)
                System.out.print(matrx[i][j] + " ");
            System.out.print("]");
        }
    }
}
