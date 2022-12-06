package com.mert.BinarySearchTree;

import java.util.*;

public class BSTGreaterSums {
    Node root;

    class Node {
        int data;
        Node left;
        Node right;
    }

    public BSTGreaterSums() {
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

    public void printList(String s, List<Integer> list) {
        System.out.print(s + " \n");
        for(int i: list)
            System.out.print(i + " ");
    }

/*
 Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that 
 every key of the original BST is changed to the original key plus the sum of all keys 
 greater than the original key in BST.  

          4(30)                                                                       
      /         \                                                                                   
     1(36)      6(21)                                                                       
   /   \         /   \                                                            
  0(36) 2(35)   5(26) 7(15)                                                                          
          \             \                                                                        
           3(33)         8(8)       
           
8 -> 8 + sumOfGreater(8) = 8
3 -> 3 + sumOfGreater(3) = 33
0 -> 0 + sumOfGreater(0) = 36

 */
    public static void main(String[] args) {
        BSTGreaterSums bst = new BSTGreaterSums();
        bst.root = bst.add(bst.root, 4);
        bst.root = bst.add(bst.root, 1);
        bst.root = bst.add(bst.root, 0);
        bst.root = bst.add(bst.root, 2);
        bst.root = bst.add(bst.root, 3);
        bst.root = bst.add(bst.root, 6);
        bst.root = bst.add(bst.root, 5);
        bst.root = bst.add(bst.root, 7);
        bst.root = bst.add(bst.root, 8);
        
       
    }

   

    
  

}
