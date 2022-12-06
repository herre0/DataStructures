package com.mert.LinkedList;

public class LinkedListLast {
    Node head;

    class Node{
        int val;
        Node next;
        Node(){next = null;}
    }

    public void insert(int value) {
        Node newNode = new Node();
        newNode.val = value;

        if(head == null){
            head = newNode;
        } else {
            Node iter = head;
            while(iter.next != null)
                iter = iter.next;

            iter.next = newNode;
        }
    }

    public void delete(int val) {
        if(head == null)
            return;

        if(head.val == val){
            head = head.next;
        } else if(head.next == null){
            head = null;
        } else {
            Node iter = head;
            while (iter.next != null && iter.next.val != val)
                iter = iter.next;

            if (iter.next == null) {
                System.out.println("not found");
                return;
            } else {
                iter.next = iter.next.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedListLast linkedList = new LinkedListLast();
        linkedList.insert(5);
        linkedList.insert(6);
        linkedList.insert(7);
        linkedList.insert(8);
        printList(linkedList.head);
        linkedList.delete(6);
        printList(linkedList.head);

    }

    public static void printList(Node head){
        Node iter = head;
        while (iter != null){
            System.out.print(iter.val + " ");
            iter = iter.next;
        }
        System.out.print("\n");
    }


}
