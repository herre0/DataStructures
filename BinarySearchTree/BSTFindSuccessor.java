package com.mert.BinarySearchTree;

import java.util.*;

public class BSTFindSuccessor {
    Node root;

    class Node {
        int data;
        Node left;
        Node right;
    }

    public BSTFindSuccessor() {
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

    public void printList(String s, List<Integer> list) {
        System.out.print(s + " \n");
        for(int i: list)
            System.out.print(i + " ");
    }

    public static void main(String[] args) {
        BSTFindSuccessor bst = new BSTFindSuccessor();
        bst.root = bst.add(bst.root, 20);
        bst.root = bst.add(bst.root, 8);
        bst.root = bst.add(bst.root, 22);
        bst.root = bst.add(bst.root, 4);
        bst.root = bst.add(bst.root, 12);
        bst.root = bst.add(bst.root, 10);
        bst.root = bst.add(bst.root, 14);
        
        Node exNode1 = bst.root.left; // 8
        Node exNode2 = bst.root.left.right.right; // 14
        Node exNode3 = bst.root; // 20
        Node exNode4 = bst.root.left.left; // 4
        Node exNode5 = bst.root.right; // 4
        System.out.println("next bigger value of " + exNode1.data + " : " + bst.getNextBigger(bst.root, exNode1).data);
        System.out.println("next bigger value of " + exNode2.data + " : " + bst.getNextBigger(bst.root, exNode2).data);
        System.out.println("next bigger value of " + exNode3.data + " : " + bst.getNextBigger(bst.root, exNode3).data);
        System.out.println("next bigger value of " + exNode4.data + " : " + bst.getNextBigger(bst.root, exNode4).data);
        System.out.println("next bigger value of " + exNode5.data + " : " + bst.getNextBigger(bst.root, exNode5));
        
    }

    public Node getNextBigger(Node root, Node x) {
        if(x.right != null)
            return getMin(x.right);

        Node nextBigger = null;
        Node curNode = root;
        while(curNode != null) {
            if(x.data < curNode.data) {
                nextBigger = curNode;
                curNode = curNode.left;
            }
            else if(x.data > curNode.data)
                curNode = curNode.right;
            else 
                break;
        }
        return nextBigger;
    }

    public Node getMin(Node root) {
         Node curNode = root;
         while(curNode.left != null)
            curNode = curNode.left;
         return curNode;   
    }

    
  

}
