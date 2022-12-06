package com.mert.Pramp;

/*
  Largest Smaller BST Key
Given a root of a Binary Search Tree (BST) and a number num, implement an efficient function findLargestSmallerKey 
that finds the largest key in the tree that is smaller than num. If such a number doesn’t exist, return -1. Assume 
that all keys in the tree are nonnegative.

Analyze the time and space complexities of your solution.

Example:
For num = 17 and the binary search tree below:

     20
    /  \
   9    25 
  / \
 5   12
    /  \
   11   14

Your function would return:

14 since it’s the largest key in the tree that is still smaller than 17.


 */

public class _03_LargestSmallerBSTKey {

    Node root;

    public static void main(String[] args) {
        _03_LargestSmallerBSTKey bst = new _03_LargestSmallerBSTKey();
        bst.insert(20);
        bst.insert(9);
        bst.insert(25);
        bst.insert(5);
        bst.insert(12);
        bst.insert(11);
        bst.insert(14);

        int result = bst.findLargestSmallerKey(17);
        System.out.println("Largest smaller number is " + result);
    }

    int findLargestSmallerKey(int num) {
        // your code goes here
        int max = -1;
        Node pivot = root;

        // 20
        while (pivot != null) {
            if (pivot.key >= num) // 14, max = 14
                pivot = pivot.left;
            else if (pivot.key < num) {
                max = pivot.key;
                pivot = pivot.right;// it's for sure
            }
        }

        return max;
    }

    class Node {
        int key;
        Node left;
        Node right;
        Node parent;

        Node(int key) {
            this.key = key;
            left = null;
            right = null;
            parent = null;
        }
    }

    void insert(int key) {

        // 1) If the tree is empty, create the root
        if (this.root == null) {
            this.root = new Node(key);
            return;
        }

        // 2) Otherwise, create a node with the key
        // and traverse down the tree to find where to
        // to insert the new node
        Node currentNode = this.root;
        Node newNode = new Node(key);

        while (currentNode != null) {
            if (key < currentNode.key) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    newNode.parent = currentNode;
                    break;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    newNode.parent = currentNode;
                    break;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }

}
