package com.mert.BinarySearchTree;

import java.util.*;

public class binaryTreeExample1 {
    TreeNode root;

    public binaryTreeExample1() {
        root = null;
    }

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

        if (tree.val > val) {
            tree.left = add(tree.left, val);
            return tree;
        }

        tree.right = add(tree.right, val);
        return tree;
    }

    public TreeNode delete(TreeNode tree, int target) {
        if(tree == null){
            return null;
        }

        if(tree.val > target){
            tree.left = delete(tree.left, target);
            return tree;
        }

        if(tree.val < target) {
            tree.right = delete(tree.right, target);
            return tree;
        }

        // when it's found
        if(tree.val == target) {
            if(tree.left == null && tree.right == null){
                tree = null;
                return tree;
            }            
            if(tree.left != null) {
                int maxVal = getMax(tree.left); 
                tree.val = maxVal;
                tree.left = delete(tree.left, maxVal);
                return tree;
            }
            if(tree.right != null) {
                int minVal = getMin(tree.right);
                tree.val = minVal;
                tree.right = delete(tree.right, minVal);
                return tree;
            }
        } 
        
        //if target is not found
        return tree;
    }

    public boolean find(TreeNode tree, int target) {
        if(tree == null)
            return false;

        if(tree.val > target)
            return find(tree.left, target);
        
        if(tree.val < target)
            return find(tree.right, target);

        if(tree.val == target)
            return true;

        // target doesn't exist    
        return false;
    }

    public int getMin(TreeNode tree) {
        if(tree == null){
            return -1;
        }

        while(tree.left != null)
            tree = tree.left;

        return tree.val;        
    }

    public int getMax(TreeNode tree){
        if(tree == null)
            return -1;


        while(tree.right != null)
            tree = tree.right;

        return tree.val;
    }

    public void printTreeLevelOrder() {
        Queue<TreeNode> que = new LinkedList();


        que.offer(root);
        while(!que.isEmpty()) {
            TreeNode pivot = que.poll();
            
            if(pivot != null){
                que.offer(pivot.left);
                que.offer(pivot.right);
            }
            
            if(pivot != null)
                System.out.print(pivot.val + " ");
            else 
                System.out.print("NULL ");
        }
    }

    public void printTreeInOrder(TreeNode root) {
        if (root == null)
            return;

        printTreeInOrder(root.left);
        System.out.print(root.val + " ");
        printTreeInOrder(root.right);
    }

    public static void main(String[] args) {
        binaryTreeExample1 bst = new binaryTreeExample1();
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

        bst.printTreeInOrder(bst.root);
        System.out.println();
        bst.printTreeLevelOrder();
        System.out.println();

        System.out.println("Min val: " + bst.getMin(bst.root));
        System.out.println("Max val: " + bst.getMax(bst.root));
        bst.root = bst.delete(bst.root, 88);
        bst.printTreeLevelOrder();
        System.out.println();
        System.out.println("Find 5: " + bst.find(bst.root, 5));
        System.out.println("Find 14: " + bst.find(bst.root, 14));
        System.out.println("Find 88: " + bst.find(bst.root, 88));
    }

}
