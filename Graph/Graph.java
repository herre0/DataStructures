package com.mert.Graph;

import java.util.*;

public class Graph {
    Map<Integer, List<Integer>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public void addVertex(int v) {
        graph.put(v, new LinkedList<>());
    }

    public void addEdge(int source, int target) {
        if (!graph.containsKey(source))
            addVertex(source);
        if (!graph.containsKey(target))
            addVertex(target);

        graph.get(source).add(target);
    }

    public int getVertexCount() {
        return graph.keySet().size();
    }

    public void getEdgeCount() {
        int count = 0;
        for (int v : graph.keySet()) {
            count += graph.get(v).size();
        }
        System.out.println("The graph has "
                + count
                + " edges");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Integer v : graph.keySet()) {
            builder.append(v.toString() + ": ");
            for (Integer w : graph.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }

        return (builder.toString());
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        // do Recursion for all the vertices adjacent to this vertex
        for (int i : graph.get(v)) {
            if (!visited[i])
                DFSUtil(i, visited);
        }
    }

    // The function to do DFS traversal.
    public void dfs(int v) {
        // Mark all the vertices as not visited(set as false by default in java)
        boolean visited[] = new boolean[getVertexCount()];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }

    public void dfsIterative(int v) {
        Stack<Integer> stack = new Stack();

        boolean visited[] = new boolean[getVertexCount()];
        stack.push(v);
        visited[v] = true;

        while (!stack.isEmpty()) {
            int curNode = stack.pop();
            System.out.print(curNode + " ");

            for (Integer neighbor : graph.get(curNode)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }


    }

    public void bfs(int vertex) {
        // Mark all the vertices as not visited(By default set as false)
        boolean visited[] = new boolean[getVertexCount()];

        Queue<Integer> queue = new LinkedList();
        // Mark the current node as visited and enqueue it
        visited[vertex] = true;
        queue.offer(vertex);

        while (queue.size() > 0) {
            // Dequeue a vertex from queue and print it
            vertex = queue.poll();
            System.out.print(vertex + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it

            for (int n : graph.get(vertex)) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.offer(n);
                }
            }

        }
    }

    public int sum(int start) {
        boolean[] visited = new boolean[getVertexCount()];

        Stack<Integer> stack = new Stack();
        stack.push(start);
        visited[start] = true;
        int sum = 0;
        while (!stack.isEmpty()) {
            int curNode = stack.pop();
            sum += curNode;

            for(Integer n: graph.get(curNode)){
                if(!visited[n]){
                    stack.push(n);
                    visited[n] = true;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Graph g = new Graph();

        g.addEdge(0, 1);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);
        g.addEdge(4, 0);


        // Printing the graph
        System.out.println("Graph:\n" + g.toString());

        // Gives the no of vertices in the graph.
        System.out.println("The graph has "
                + g.getVertexCount()
                + " vertex");

        // Gives the no of edges in the graph.
        g.getEdgeCount();

        System.out.print("DFS: ");
        g.dfs(0);

        System.out.print("\nDFS ITERATIVE: ");
        g.dfsIterative(0);

        System.out.print("\nBFS: ");
        g.bfs(0);

        System.out.print("\nSUM: "+ g.sum(0));

    }

}


