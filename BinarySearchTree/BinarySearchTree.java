package com.mert.BinarySearchTree;

import java.util.Stack;

public class BinarySearchTree {
    Node root;

    class Node {
        int data;
        Node left;
        Node right;
    }

    public BinarySearchTree() {
        this.root = null;
    }

    Node add(Node tree, int value) {
        if (tree == null) {
            Node root = new Node();
            root.right = null;
            root.left = null;
            root.data = value;
            return root;
        }

        if (value < tree.data) {
            tree.left = add(tree.left, value);
            return tree;
        }


        tree.right = add(tree.right, value);
        return tree;

    }

    void travel(Node tree) {
        if (tree == null)
            return;
        travel(tree.left);
        System.out.print(tree.data + " ");
        travel(tree.right);
    }

    int find(Node tree, int value) {
        if (tree == null)
            return -1;
        if (tree.data == value)
            return 1;

        if (find(tree.left, value) == 1)
            return 1;
        if (find(tree.right, value) == 1)
            return 1;

        return -1;
    }

    int getMax(Node tree) {
        Node iter = tree;
        while (iter.right != null)
            iter = iter.right;

        return iter.data;
    }

    int getMin(Node tree) {
        Node iter = tree;
        while (iter.left != null)
            iter = iter.left;

        return iter.data;
    }

    Node delete(Node tree, int value) {
        if (tree == null)
            return null;
        if (value < tree.data) {
            tree.left = delete(tree.left, value);
            return tree;
        }
        if (value > tree.data) {
            tree.right = delete(tree.right, value);
            return tree;
        }

        // istenen node bulununca value==tree.data
        if (tree.left == null && tree.right == null) {
            tree = null;
            return tree;
        }
        if (tree.left != null) {
            tree.data = getMax(tree.left);
            tree.left = delete(tree.left, getMax(tree.left));
            return tree;
        }
        if (tree.right != null) {
            tree.data = getMin(tree.right);
            tree.right = delete(tree.right, getMin(tree.right));
            return tree;
        }

        return tree;
    }
    
    public void iterativeInOrder(Node root) {
        Stack<Node> stack = new Stack();
        Node curNode = root;
        while(!stack.isEmpty() || curNode != null) {
            while(curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            }

            curNode = stack.pop();
            System.out.print(curNode.data + " ");
            curNode = curNode.right;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
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

        bst.travel(bst.root);
        System.out.println("Arama Sonucu: " + bst.find(bst.root, 100));
        System.out.print("Max : " + bst.getMax(bst.root));
        System.out.println(" Min : " + bst.getMin(bst.root));

    }


}
