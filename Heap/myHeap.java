package com.mert.Heap;

public class myHeap {
    int[] heap; // will be 1-indexed and min heap
    int size;

    public myHeap(){
        heap = new int[50];
        size = 0;
    }

    void insert(int value) {
        heap[++size] = value;
        bubbleUp(size);
    }

    void bubbleUp(int index) {
        int parentIndex = index / 2;

        if(parentIndex <= 1 || heap[parentIndex] <= heap[index])
            return;

        swap(parentIndex, index);

        bubbleUp(parentIndex);
    }

    // deletes the root of Heap
    int delete() {
        int minValue = heap[1];
        heap[1] = heap[size--];
        sinkDown(1);
        return minValue;
    }

    void sinkDown(int index) {
        if(isLeaf(index))
            return;

        int leftChild = index / 2;
        int rightChild = (index/2)+1;
        int minChildIndex;

        if(rightChild > size)
            minChildIndex = leftChild;
        else
            minChildIndex = (heap[leftChild] < heap[rightChild]) ? leftChild : rightChild;
        

        if(heap[index] < heap[minChildIndex])
            return;

        swap(index, minChildIndex);
        sinkDown(minChildIndex);
    }

    boolean isLeaf(int index) {
        return (heap[index] * 2) > size;
    }

    void swap(int i1, int i2){
        int temp = heap[i1];
        heap[i1] = heap[i2];
        heap[i2] = temp;
    }

    void printHeap(){
        for(int i = 1; i <= size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(15);
        heap.insert(5);
        heap.insert(1);
        heap.insert(8);
        heap.insert(3);
        heap.printHeap();
        heap.remove();
        heap.printHeap();
    }

    
}
