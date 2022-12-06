package com.mert.Heap;

public class HeapDeneme {
    int[] heap;
    int size = 0;

    public HeapDeneme() {
        heap = new int[10];
        heap[0] = -1;
    }

    void insert(int value) {
        heap[++size] = value;
        bubbleUp(size);
    }

    void bubbleUp(int childIndex) {
        int parentIndex = childIndex / 2;

        // check if index is root or parent's already smaller than the child
        if (childIndex == 1 || heap[parentIndex] < heap[childIndex])
            return;

        swap(parentIndex, childIndex);
        bubbleUp(parentIndex);
    }

    void swap(int parentIndex, int childIndex) {
        int tempValue = heap[parentIndex];
        heap[parentIndex] = heap[childIndex];
        heap[childIndex] = tempValue;
    }

    int remove() {
        int removedValue = heap[1];
        int lastValue = heap[size--];
        heap[1] = lastValue;
        sinkDown(1);
        return removedValue;
    }

    boolean isLeaf(int index) {
        return (index * 2) > size;
    }

    void sinkDown(int parentIndex) {
        if (this.isLeaf(parentIndex)) return;


        int rChildIndex = (parentIndex * 2) + 1;
        int lChildIndex = parentIndex * 2;
        int minChildIndex;

        //check the children here, which is which or smaller
        if(rChildIndex > size) {
            minChildIndex = lChildIndex;
        } else {
            minChildIndex = (heap[rChildIndex] > heap[lChildIndex]) ? lChildIndex : rChildIndex;
        }

        //if parent is already smaller than the child, return
        if(heap[parentIndex] < heap[minChildIndex])
            return;

        swap(parentIndex, minChildIndex);
        sinkDown(minChildIndex);
    }

    void printHeapList() {
        for(int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HeapDeneme h = new HeapDeneme();
        h.insert(2);
        h.insert(4);
        h.insert(1);
        h.insert(-10);
        h.printHeapList();
        h.remove();
        h.printHeapList();
    }


}
