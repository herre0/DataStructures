package com.mert.BinarySearchTree;

import java.util.*;

public class BTSideViews {
    Node root;

    class Node {
        int data;
        Node left;
        Node right;
    }

    public BTSideViews() {
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

    public void printList(String s, List<Integer> list) {
        System.out.print(s + " \n");
        for(int i: list)
            System.out.print(i + " ");
    }

    public static void main(String[] args) {
        BTSideViews bst = new BTSideViews();
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

        List<Integer> rightSideList = new ArrayList();
        List<Integer> leftSideList = new ArrayList();
        List<Integer> pyramidViewList = new ArrayList();
        List<Integer> pyramidViewList2 = new ArrayList();
        bst.rightSideView(bst.root, rightSideList, 0);
        bst.printList("Right Side View:", rightSideList);
        
        bst.leftSideView(bst.root, leftSideList, 0);
        bst.printList("Left Side View:", leftSideList);

        bst.pyramidView(bst.root, pyramidViewList);
        bst.printList("Pyramid View:", pyramidViewList);

        bst.pyramidView2(bst.root, pyramidViewList2);
        bst.printList("Pyramid View2:", pyramidViewList2);
    }

    public void rightSideView(Node root, List<Integer> result, int currDepth) {
        if(root == null)
            return;
        
        if(currDepth == result.size())
            result.add(root.data);

        rightSideView(root.right, result, currDepth + 1);
        rightSideView(root.left, result, currDepth + 1);
    }

    public void leftSideView(Node root, List<Integer> result, int currDepth) {
        if(root == null)
            return;

        if(currDepth == result.size())
            result.add(root.data);

        leftSideView(root.left, result, currDepth + 1);
        leftSideView(root.right, result, currDepth + 1);
    }

    public void pyramidView(Node root, List<Integer> result) { //  view of /\ 
        Queue<Node> que = new LinkedList();

        que.offer(root);
        while(!que.isEmpty()) {
            int size = que.size();
            int initialSize = size;
            while(size > 0) {
                Node curNode = que.poll();
                size--;
                if(size == 0 || size == initialSize-1)
                    result.add(curNode.data);

                if(curNode.left != null)
                    que.offer(curNode.left);
                if(curNode.right != null)
                    que.offer(curNode.right);
            }
        }
    }
                                                                 //          /\   
    public void pyramidView2(Node root, List<Integer> result) { //  view of /__\ 
        Queue<Node> que = new LinkedList();

        que.offer(root);
        while(!que.isEmpty()) {
            int size = que.size();
            int initialSize = size;
            while(size > 0) {
                Node curNode = que.poll();
                size--;
                if(size == 0 || size == initialSize-1 || (curNode.left==null && curNode.right==null))
                    result.add(curNode.data);

                if(curNode.left != null)
                    que.offer(curNode.left);
                if(curNode.right != null)
                    que.offer(curNode.right);
            }
        }
    }


}
