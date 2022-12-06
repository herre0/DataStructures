package com.mert.BinaryTree;

import com.mert.BinarySearchTree.BinaryTree;

public class Tree {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = bt.add(bt.root, 29);
        bt.root = bt.add(bt.root, 35);
        bt.root = bt.add(bt.root, 47);
        bt.root = bt.add(bt.root, 14);
    }


}
