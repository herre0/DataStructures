package com.mert.Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph2 {
    Map<Integer, List<Integer>> map;

    public Graph2(){
        map = new HashMap<>();
    }

    public void addVertex(int v) {
        map.put(v, new LinkedList<>());
    }

    public void addEdge(int source, int target) {
        if(!map.containsKey(source))
            addVertex(source);
        if(!map.containsKey(target))
            addVertex(target);

        map.get(source).add(target);
    }

    public void print() {
        for (Integer v : map.keySet()) {
            System.out.print(v + ": ");
            for (Integer n : map.get(v)) {
                System.out.print(n + " ");
            }
            System.out.print("\n");
        }
    }

    public int getVertexCount(){
        return map.keySet().size();
    }

    public int getEdgeCount() {
        int count = 0;
        for(Integer v: map.keySet()) {
            count += map.get(v).size();
        }
        return count;
    }

    public void dfs(int vertex) {
        if(!map.containsKey(vertex))
            System.out.print("not present");

        boolean[] visited = new boolean[getEdgeCount()];
        dfsUtil(vertex, visited);
    }

    public void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for(Integer neighbor: map.get(v)){
            if(!visited[neighbor])
                dfsUtil(neighbor, visited);
        }
    }

    public static void main(String[] args) {
        Graph2 g = new Graph2();

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);


        // Printing the graph
        g.print();

        // Gives the number of vertices in the graph.
        System.out.println("The graph has "
                + g.getVertexCount()
                + " vertex");

        // Gives the number of edges in the graph.
        System.out.println("The graph has "
                + g.getEdgeCount()
                + " edges");

        g.dfs(0);
    }




}

