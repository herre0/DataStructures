package com.mert.LeetCode;

public class ConvertArraytoBST {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        int nums[] = {-10, -3, 0, 5, 9};
        ConvertArraytoBST convertArraytoBST = new ConvertArraytoBST();
        convertArraytoBST.helper(nums, 0, nums.length - 1);
    }


    public TreeNode helper(int nums[], int l, int r) {
        if (l > r)
            return null;

        int m = (l + r) / 2;

        TreeNode root = new TreeNode(nums[m]);
        root.left = helper(nums, l, m-1);
        System.out.print(root.val + " ");
        root.right = helper(nums, m+1, r);
        return root;
    }
}
