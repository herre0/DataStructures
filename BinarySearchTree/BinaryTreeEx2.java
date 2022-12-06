package com.mert.BinarySearchTree;

import java.util.*;

public class BinaryTreeEx2 {
    TreeNode root;

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    public TreeNode add(TreeNode tree, int val) {
        if (tree == null) {
            tree = new TreeNode();
            tree.left = null;
            tree.right = null;
            tree.val = val;
            return tree;
        }

        if (tree.val < val) {
            tree.right = add(tree.right, val);
            return tree;
        }

        tree.left = add(tree.left, val);
        return tree;
    }

    public TreeNode delete(TreeNode tree, int target) {
        if (tree == null)
            return null;

        if (tree.val < target) {
            tree.right = delete(tree.right, target);
            return tree;
        }
        if (tree.val > target) {
            tree.left = delete(tree.left, target);
            return tree;
        }

        if (tree.val == target) {
            if (tree.left == null && tree.right == null) {
                tree = null;
                return tree;
            }
            if (tree.left != null) {
                int maxVal = getMax(tree.left);
                tree.val = maxVal;
                tree.left = delete(tree.left, maxVal);
                return tree;
            }
            if (tree.right != null) {
                int minVal = getMin(tree.right);
                tree.val = minVal;
                tree.right = delete(tree.right, minVal);
                return tree;
            }
        }

        // target not found
        return tree;
    }

    public int getMax(TreeNode tree) {
        if (tree == null)
            return -1;

        TreeNode pivot = tree;
        while (pivot.right != null)
            pivot = pivot.right;

        return pivot.val;
    }

    public int getMin(TreeNode tree) {
        if (tree == null)
            return -1;

        TreeNode pivot = tree;
        while (pivot.left != null)
            pivot = pivot.left;

        return pivot.val;
    }

    public boolean find(TreeNode tree, int target) {
        if (tree == null) {
            return false;
        }

        if (tree.val < target) {
            return find(tree.right, target);
        }

        if (tree.val > target) {
            return find(tree.left, target);
        }

        if (tree.val == target)
            return true;
        // target is not found
        return false;
    }

    public void printLevelOrder() {
        Queue<TreeNode> que = new LinkedList();

        que.offer(this.root);
        while (!que.isEmpty()) {
            TreeNode pivot = que.poll();
            if (pivot != null) {
                que.offer(pivot.left);
                que.offer(pivot.right);
                System.out.print(pivot.val + " ");
            } else
                System.out.print("NULL ");

        }
    }

    public void printInOrder(TreeNode tree) {
        if (tree == null) {
            return;
        }
        printInOrder(tree.left);
        System.out.print(tree.val + " ");
        printInOrder(tree.right);
    }

    public static void main(String[] args) {
        BinaryTreeEx2 bst = new BinaryTreeEx2();
        bst.root = bst.add(bst.root, 11);
        bst.root = bst.add(bst.root, 6);
        bst.root = bst.add(bst.root, 15);
        bst.root = bst.add(bst.root, 3);
        bst.root = bst.add(bst.root, 8);
        bst.root = bst.add(bst.root, 13);
        bst.root = bst.add(bst.root, 17);
        bst.root = bst.add(bst.root, 1);
        bst.root = bst.add(bst.root, 5);
        bst.root = bst.add(bst.root, 12);
        bst.root = bst.add(bst.root, 14);
        bst.root = bst.add(bst.root, 19);

        bst.printInOrder(bst.root);
        System.out.println();
        bst.printLevelOrder();
        System.out.println();

        System.out.println("Min val: " + bst.getMin(bst.root));
        System.out.println("Max val: " + bst.getMax(bst.root));
        bst.root = bst.delete(bst.root, 6);
        bst.root = bst.delete(bst.root, 88);
        bst.printLevelOrder();
        System.out.println();
        System.out.println("Find 5: " + bst.find(bst.root, 5));
        System.out.println("Find 14: " + bst.find(bst.root, 14));
        System.out.println("Find 88: " + bst.find(bst.root, 88));
    }

}
