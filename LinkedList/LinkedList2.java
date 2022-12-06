package com.mert.LinkedList;

public class LinkedList2 {
    Node root;

    LinkedList2() {
        root = null;
    }

    class Node {
        int data;
        Node next;
    }

    void insertWithSequence(int value) {
        Node newNode = new Node();
        newNode.data = value;
        if (root == null) {
            root = newNode;
            root.next = null;
        } else if (root.data > value) {
            newNode.next = root;
            root = newNode;
        } else {
            Node iter = root;
            while (iter.next != null && iter.next.data < value)
                iter = iter.next;

            newNode.next = iter.next;
            iter.next = newNode;
        }
    }

    void remove(int value) {
        if(root == null){
            System.out.println("eleman yok aq");
            return;
        }

        if(value == root.data) {
            root = root.next;
        } else if(root.next == null) {//1 eleman
            root = null;
        } else {// ortadan veya sondan
            Node iter = root;
            while(iter.next != null && iter.next.data != value)
                iter = iter.next;

            if(iter.next == null) {
                System.out.println("sayi bulunmaadi");
                return;
            } else {
                iter.next = iter.next.next;
            }
        }




    }

    void print() {
        Node iter = root;
        while (iter != null) {
            System.out.print(iter.data + " ");
            iter = iter.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList2 linkedList = new LinkedList2();

        linkedList.insertWithSequence(40);
        linkedList.insertWithSequence(10);
        linkedList.insertWithSequence(20);
        linkedList.insertWithSequence(30);
        linkedList.insertWithSequence(50);

        linkedList.print();
        linkedList.remove(10);
        linkedList.remove(50);
        linkedList.print();
    }
}
