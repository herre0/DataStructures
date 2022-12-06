package com.mert.BinarySearchTree;

public class binaryTreeDeneme {
    Node root;

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            left = null;
            right = null;
            this.value = value;
        }
    }

    public binaryTreeDeneme() {
        root = null;
    }

    Node add(Node tree, int value) {
        if (tree == null) {
            Node root = new Node(value);
            return root;
        }
        if (value < tree.value) {
            tree.left = add(tree.left, value);
            return tree;
        }
        if (value > tree.value) {
            tree.right = add(tree.right, value);
            return tree;
        }
        return tree;
    }

    void doTraversal(Node tree) {
        if (tree == null)
            return;

        doTraversal(tree.left);
        System.out.print(tree.value + " ");
        doTraversal(tree.right);
    }

    int find(Node tree, int value) {
        if (tree == null)
            return -1;
        if(tree.value== value)
            return 1;

        if(find(tree.right, value) == 1)
            return 1;
        if(find(tree.left, value) == 1)
            return 1;

        return -1;
    }

    int getMax(Node tree) {
        Node iter = tree;
        while(iter.right != null)
            iter = iter.right;

        return iter.value;
    }

    int getMin(Node tree) {
        Node iter = tree;
        while (iter.left != null)
            iter = iter.left;

        return iter.value;
    }

    Node remove(Node tree, int value) {
        if (tree == null)
            return null;
        if(value < tree.value) {
            tree.left = remove(tree.left, value);
            return tree;
        }
        if(value > tree.value){
            tree.right = remove(tree.right, value);
            return tree;
        }
        // value == tree.value, we found the value that we need to remove
        if(tree.left == null && tree.right == null) {
            tree = null;
            return  tree;
        }
        if(tree.left != null) {
            tree.value = getMax(tree.left);
            tree.left = remove(tree.left, getMax(tree.left));
            return tree;
        }
        if(tree.right != null) {
            tree.value = getMin(tree.right);
            tree.right = remove(tree.right, getMin(tree.right));
            return tree;
        }
        return tree;
    }

    public static void main(String[] args) {
        binaryTreeDeneme bst = new binaryTreeDeneme();
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

        bst.doTraversal(bst.root);
        System.out.println("Arama Sonucu: " + bst.find(bst.root, 100));
        System.out.print("Max : " + bst.getMax(bst.root));
        System.out.println(" Min : " + bst.getMin(bst.root));
        bst.root = bst.remove(bst.root, 11);

        bst.doTraversal(bst.root);
    }




}
