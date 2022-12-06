package com.mert.Heap;

import java.util.PriorityQueue;

public class KClosestPoint {

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));
        
        for(int[] point: points){
            pq.add(point);
            if(pq.size() > k)
                pq.remove();
        }       
        
        int[] ans = pq.poll();
        System.out.println(ans[0] + ", " + ans[1]);
        
    }
    
     

}

