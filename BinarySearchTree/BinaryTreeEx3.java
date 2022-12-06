package com.mert.BinarySearchTree;

import java.util.*;

public class BinaryTreeEx3 {
    TreeNode root;

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    public TreeNode add(TreeNode tree, int val) {
        if (tree == null) {
            TreeNode root = new TreeNode();
            root.left = null;
            root.right = null;
            root.val = val;
            return root;
        }

        if (tree.val < val) {
            tree.right = add(tree.right, val);
            return tree;
        }

        tree.left = add(tree.left, val);
        return tree;
    }

    public TreeNode delete(TreeNode root, int target) {
        if(root == null)
            return null;

        // find the node 
        if(root.val < target){
            root.right = delete(root.right, target);
            return root;
        }             

        if(root.val > target){
            root.left = delete(root.left, target);
            return root;
        }            

        if(root.val == target) {    
            // leaf node
            if(root.left == null && root.right == null){
                root = null;
                return root;
            }

            if(root.left != null){
                int maxFromLeft = getMax(root.left);
                root.val = maxFromLeft;
                root.left = delete(root.left, maxFromLeft);
                return root;
            }

            if(root.right != null) {
                int minFromRight = getMin(root.right);
                root.val = minFromRight;
                root.right = delete(root.right, minFromRight);
                return root;
            }
        }
        // target not found
        return root;
    }

    public int getMin(TreeNode tree) {
        if (tree == null)
            return -1;

        while (tree.left != null)
            tree = tree.left;
        return tree.val;
    }

    public int getMax(TreeNode tree) {
        if (tree == null)
            return -1;

        while (tree.right != null)
            tree = tree.right;

        return tree.val;
    }

    public boolean find(TreeNode tree, int target) {
        if (tree == null)
            return false;

        if (tree.val < target) {
            return find(tree.right, target);
        }

        if (tree.val > target) {
            return find(tree.left, target);
        }

        if (tree.val == target) {
            return true;
        }

        // target is not found
        return false;
    }

    public void printLevelOrder() {
        Queue<TreeNode> que = new LinkedList();
        que.offer(root);

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
        if (tree == null)
            return;

        printInOrder(tree.left);
        System.out.print(tree.val + " ");
        printInOrder(tree.right);
    }

    public static void main(String[] args) {
        BinaryTreeEx3 bst = new BinaryTreeEx3();
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
        bst.root = bst.delete(bst.root, 11);
        bst.root = bst.delete(bst.root, 88);
        System.out.println("11 is deleted");
        bst.printLevelOrder();
        System.out.println();
        System.out.println("Find 5: " + bst.find(bst.root, 5));
        System.out.println("Find 14: " + bst.find(bst.root, 14));
        System.out.println("Find 88: " + bst.find(bst.root, 88));
    }
}
