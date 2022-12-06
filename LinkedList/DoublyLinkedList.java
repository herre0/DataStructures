package com.mert.LinkedList;

public class DoublyLinkedList {
    int size;
    Node root;

    class Node {
        int data;
        Node next;
        Node prev;
    }

    DoublyLinkedList() {
        root = null;
    }

    void insertWithSequence(int value) {
        Node newNode = new Node();
        newNode.data = value;

        if(root == null) {
            newNode.next = null;
            newNode.prev = null;
            root = newNode;
        } else if(value < root.data) {
            newNode.next = root;
            newNode.prev = null;
            root.prev = newNode;
            root = newNode;
        } else {//ortaya veya sona eklendiginde
            Node iter = root;
            while(iter.next != null && iter.next.data < value)
                iter = iter.next;

            newNode.next = iter.next;
            if(iter.next != null)
                newNode.prev = iter;
            iter.next = newNode;
        }
        size++;
    }

    void print() {
        Node iter = root;
        for(int i = 0; i < size; i++) {
            System.out.print(iter.data + " <-> ");
            iter = iter.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();

        linkedList.insertWithSequence(100);
        linkedList.insertWithSequence(50);
        linkedList.insertWithSequence(75);
        linkedList.insertWithSequence(150);
        linkedList.insertWithSequence(200);
        linkedList.print();

    }
}
