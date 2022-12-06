package com.mert.Heap;

import java.util.*;

public class PriorityQueueJava {


    public static void main(String[] args) {


        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        minHeap.offer(8);
        minHeap.offer(10);
        

        System.out.println(minHeap);//this is minHeap structure you see
        System.out.println(minHeap.poll());
        System.out.println(minHeap);
        System.out.println(minHeap.poll());
        System.out.println(minHeap);
        System.out.println(minHeap.remove(8));
        System.out.println(minHeap);

    }
    /*
     * methods:
     * --------
     * add(val): inserts into queue
     * offer(val): inserts into queue
     * remove(val): removes from queue
     * remove() : retrieves and removes the root of queue
     * poll() : retrieves and removes the root of the queue
     * peek() : just retrieves the root of the queue
     * 
     * 
     * 
     * 
     */
    
}
