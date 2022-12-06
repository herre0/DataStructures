package com.mert.BinarySearchTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    public TreeNode root;

    public BinaryTree(){
        root = null;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public TreeNode add(TreeNode tree, int val){
        if(tree == null) {
            TreeNode newNode = new TreeNode();
            newNode.val = val;
            return newNode;
        }

        if(tree.val < val) {
            tree.right = add(tree.right, val);
            return tree;
        }

        tree.left = add(tree.left, val);
        return tree;
    }

    public TreeNode delete(TreeNode root, int val) {
        if(root == null)
            return null;

        if(val < root.val) {
            root.left = delete(root.left, val);
            return root.left;
        }

        if(val > root.val) {
            root.right = delete(root.right, val);
            return root.right;
        }

        if(root.left != null){
            root.val = getMax(root.left);
            root.left = delete(root.left, getMax(root.left));
            return root;
        }

        if(root.right != null) {
            root.val = getMin(root.right);
            root.right = delete(root.right, getMin(root.right));
        }

        if(root.right == null && root.left == null) {
            root = null;
            return root;
        }

        return root;
    }

    public void traverse(TreeNode tree) {
        if(tree == null)
            return;
        traverse(tree.left);
        System.out.print(tree.val + " ");
        traverse(tree.right);
    }

    public int find(TreeNode tree, int val) {
        if(tree == null)
            return -1;

        if(tree.val == val)
            return 1;

        if(find(tree.left, val) == 1)
            return 1;

        if(find(tree.right, val) == 1)
            return 1;

        return -1;
    }

    public int getMax(TreeNode tree) {
        TreeNode iter = tree;
        while(iter.right != null)
            iter = iter.right;

        return iter.val;
    }

    public int getMin(TreeNode tree) {
        TreeNode iter= tree;
        while(iter.left != null)
            iter = iter.left;

        return iter.val;
    }

    public int sumValuesinTree(TreeNode tree) {
        if(tree == null)
            return 0;

        int sumLeft = sumValuesinTree(tree.left);
        int sum = tree.val;
        int sumRight = sumValuesinTree(tree.right);

        return sumLeft + sumRight + sum;
    }

    public int countOddNumbers(TreeNode tree) {
        if(tree == null)
            return 0;

        int leftCount = countOddNumbers(tree.left);
        int count = tree.val % 2 != 0 ? 1 : 0;
        int rightCount = countOddNumbers(tree.right);

        return leftCount + count + rightCount;
    }

    public int findNumber(TreeNode root, int num) {
        if(root == null)
            return -1;

        if(root.val == num)
            return 1;

        if(findNumber(root.left, num) == 1)
            return 1;

        if(findNumber(root.right, num) == 1)
            return 1;

        return -1;
    }

    public boolean findNumber2(TreeNode root, int num) {
        if(root == null)
            return false;

        if(root.val == num)
            return true;

        return findNumber2(root.left, num) || findNumber2(root.right, num);
    }

    public TreeNode convertArrayToBST(int[] arr) {
        TreeNode myRoot = null;
        for(int i = 0; i < arr.length; i++) {
            myRoot = myAdd(myRoot, arr[i]);
        }
        return myRoot;
    }

    public TreeNode myAdd(TreeNode root, int val) {
        if(root == null) {
            TreeNode newNode = new TreeNode();
            newNode.val = val;
            return newNode;
        }

        if(root.val < val) {
            root.right = myAdd(root.right, val);
            return root;
        }

        root.left = myAdd(root.left, val);
        return root;
    }

    public void postOrderTraversal(TreeNode root) {
        if(root == null)
            return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.val + " ");
    }

    public void preOrderTraversal(TreeNode root) {
        if(root == null)
            return;

        System.out.print(root.val + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();

            if(cur.left != null)
                queue.offer(cur.left);
            if(cur.right != null)
                queue.offer(cur.right);

            System.out.print(cur.val + " ");
        }
    }

    public void dfs(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            if(cur.left != null)
                stack.push(cur.left);
            if(cur.right != null)
                stack.push(cur.right);

            System.out.print(cur.val + " ");
        }
    }

    public void iterativeInOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode curNode = root;
        while(!stack.isEmpty() || curNode != null) {
            while(curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            }

            curNode = stack.pop();
            System.out.print(curNode.val + " ");
            curNode = curNode.right;
        }
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.root = bt.add(bt.root, 5);
        bt.root = bt.add(bt.root, 4);
        bt.root = bt.add(bt.root, 3);
        bt.root = bt.add(bt.root, 8);
        bt.root = bt.add(bt.root, 2);
        bt.root = bt.add(bt.root, 6);
        bt.root = bt.add(bt.root, 9);

        System.out.println("sum: "+bt.sumValuesinTree(bt.root));
        System.out.println("odds count: "+bt.countOddNumbers(bt.root));
        System.out.println("find Number: "+bt.findNumber(bt.root, 5));
        System.out.println("find Number2: "+bt.findNumber2(bt.root, 9));
        //System.out.println("convert Array: ");
        //bt.traverse(bt.convertArrayToBST(new int[]{2, 3, 7, 4, 8, 9}));
        System.out.println("bfs: ");
        bt.bfs(bt.root);
        System.out.println("\nIn order Iterative: ");
        bt.iterativeInOrder(bt.root);

       




    }
}
