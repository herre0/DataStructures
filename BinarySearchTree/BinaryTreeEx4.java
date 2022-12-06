package com.mert.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeEx4 {
    TreeNode root;

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    // add
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

    public TreeNode delete(TreeNode tree, int target) {
        if(tree == null) {
            return null;
        }

        // find the target
        if(target < tree.val) {
            tree.left = delete(tree.left, target);
            return tree;
        }

        if(target > tree.val) {
            tree.right = delete(tree.right, target);
            return tree;
        }

        if(target == tree.val) {
            // leaf node
            if(tree.left == null && tree.right == null) {
                tree = null;
                return tree;
            }
            // both ways work, replace it with min of RightSubTree or max of LeftSubtree
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
        // target not found
        return tree;
    }

    public int getMin(TreeNode tree) {
        if(tree == null)
            return -1;

        while(tree.left != null)
            tree = tree.left;
        return tree.val;
    }

    public int getMax(TreeNode tree) {
        if(tree == null)
            return -1;

        while(tree.right!= null)
            tree = tree.right;
        return tree.val;
    }

    public boolean find(TreeNode tree, int target) {
        if(tree == null) 
            return false;

        if(target < tree.val) {
            return find(tree.left, target);
        }

        if(target > tree.val) {
            return find(tree.right, target);
        }

        if(target == tree.val) {
            return true;
        }

        // none of the conditions are met
        return false;
    }

    public void printLevelOrder() {
        Queue<TreeNode> que = new LinkedList();
        que.offer(this.root);

        while(!que.isEmpty()) {
            TreeNode curNode = que.poll();

            if(curNode != null) {
                que.offer(curNode.left);
                que.offer(curNode.right);
                System.out.print(curNode.val + " ");    
            } else {
                System.out.print("NULL ");
            }
        }
    }

    public void printInOrder(TreeNode tree) {
        if(tree == null)
            return;
        printInOrder(tree.left);
        System.out.print(tree.val + " ");
        printInOrder(tree.right);
    }

    public static void main(String[] args) {
        BinaryTreeEx4 bst = new BinaryTreeEx4();
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

