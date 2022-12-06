package com.mert.Heap;

import java.util.*;

// min heap
public class Heap {

    int[] heap = new int[10];
    int size = 0;

    public Heap() {
        heap[0] = -1;
    }

    void insert(int value) {
        heap[++size] = value;
        bubbleUp(size);
    }

    // adjusting a newly added element upwards in order to preserve
    // min heap property
    void bubbleUp(int index) {
        // Find the parent index
        int parentIndex = index / 2;

        // if parent is smaller than children, don't need to do anything
        if (index == 1 || heap[parentIndex] < heap[index])
            return;

        swap(parentIndex, index);

        // Recursively do the same thing with new parent
        bubbleUp(parentIndex);
    }

    // put the last value to root node then adjust elements
    // in order to preserve min heap property
    int remove() {
        int minValue = heap[1];
        heap[1] = heap[size--];
        sinkDown(1);
        return minValue;
    }

    boolean isLeaf(int index) {
        return (index * 2) > size;
    }

    void sinkDown(int index) {
        if (isLeaf(index))
            return;

        int leftChildIndex = index * 2;
        int rightChildIndex = (index * 2) + 1;
        int minChildIndex;

        // TASK: Check if rightChildren doesn't exist, in that case
        // the minChildIndex is the left, otherwise, find the min children
        // if right child exists, left child has to exist (it's a complete bt)
        if (rightChildIndex > size)
            minChildIndex = leftChildIndex;
        else 
            minChildIndex = (heap[leftChildIndex] < heap[rightChildIndex]) ? leftChildIndex : rightChildIndex;
        

        // if parent is already smaller than the children
        if (heap[index] < heap[minChildIndex])
            return;

        swap(index, minChildIndex);
        // apply the same algorithm recursively
        sinkDown(minChildIndex);
    }

    // Swaps children and parent
    void swap(int parentIndex, int childIndex) {
        int tempValue = heap[childIndex];
        heap[childIndex] = heap[parentIndex];
        heap[parentIndex] = tempValue;
    }

    int minValue() {
        return heap[1];
    }

    int length() {
        return size;
    }

    void printHeap() {
        for (int i = 1; i <= size; i++) {            
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(1);
        h.insert(3);
        h.insert(5);
        h.insert(15);
        h.insert(8);
        h.printHeap();
        h.remove();
        h.printHeap();
    }
}
