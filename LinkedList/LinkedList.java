package com.mert.LinkedList;

public class LinkedList {
    private int size = 0;
    private Node root;

    class Node {
        int data;
        Node next;
    }

    LinkedList() {
        root = null;
    }

    void insert(int value) {
        Node newNode = new Node();
        newNode.data = value;
        Node iter = this.root; // makes it possible to loop through the linked list

        if (root == null) {
            root = newNode;
            root.next = null;
            size++;
        } else {
            while (iter.next != null)
                iter = iter.next;

            iter.next = newNode;
            newNode.next = null;
            size++;
        }
    }

    void insertWithSequence(int value) {
        Node newNode = new Node();
        newNode.data = value;

        if(root == null) { // linked list bosken eklenmesi
            root = newNode;
            root.next = null;
        } else if(value < root.data) { // ilk elemandan once eklenmesi
            newNode.next = root;
            root = newNode;
        } else { // araya veya sona eklenmesi
            Node iter = root;
            while(iter.next != null && iter.next.data < value)
                iter = iter.next;

            newNode.next = iter.next;
            iter.next = newNode;
        }
        size++;
    }

    void delete(int value) {
        if(root == null) {
            System.out.println("LinkedList is Empty!");
            return;
        }

        if(value == root.data) {// silinecek deger root ise
            root = root.next;
        } else if(size == 1) {//  1 eleman varsa silmek
            root = null;
            size = 0;
        } else { // aradan veya sondan eleman silmek
            Node iter = root;
            while(iter.next != null && iter.next.data != value)
                iter = iter.next;

            if(iter.next == null) {
                System.out.println("deger bulunamadi");
                return;
            } else {
                iter.next = iter.next.next;
            }
        }
        size--;
        System.out.println(value + " silindi");
    }

    void print() {
        Node iter = root;
        while (iter != null) {
           System.out.print(iter.data + " -> ");
            iter = iter.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertWithSequence(100);
        linkedList.insertWithSequence(50);
        linkedList.insertWithSequence(75);
        linkedList.insertWithSequence(150);
        linkedList.insertWithSequence(200);
        linkedList.print();
        linkedList.delete(75);
        linkedList.print();
        linkedList.delete(50);
        linkedList.print();
        linkedList.delete(200);
        linkedList.print();
        linkedList.delete(250);
        linkedList.print();
    }


}
