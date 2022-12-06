package com.mert.Graph;

import java.util.*;

public class CurrencyCalc2 {

    public static void main(String[] args) {
        // create graph
        HashMap<String, List<Node>> graph = new HashMap();

        // [from, to, rate]
        String[][] currencies = {
            {"USD", "TRY", "18.40"},
            {"USD", "EUR", "1.02"},
            {"TRY", "JPY", "7.73"},
            {"JPY", "GBP", "0.0063"},
            {"GBP", "CAD", "1.51"},
            {"EUR", "CAD", "1.32"}
        };

        // fill graph, undirected graph
        for(String[] currency: currencies) {
            String source = currency[0];
            String dest = currency[1];
            double rate = Double.valueOf(currency[2]);

            if(!graph.containsKey(source))
                graph.put(source, new ArrayList());
            if(!graph.containsKey(dest))
                graph.put(dest, new ArrayList());

            graph.get(source).add(new Node(dest, rate));
            graph.get(dest).add(new Node(source, 1/rate));
        }

        System.out.println(getRate(graph, "USD", "CAD"));
        System.out.println(getRate(graph, "USD", "GBP"));
        System.out.println(getRate(graph, "EUR", "TRY"));
        System.out.println(getRate(graph, "USD", "TTT"));
        System.out.println(getRate(graph, "TRY", "USD"));
    }
    // bfs starting from source
    public static double getRate(HashMap<String, List<Node>> graph, String source, String target) {

        Queue<Node> que = new LinkedList();
        HashSet<String> visited = new HashSet();
        que.offer(new Node(source, 1.0));

        while(!que.isEmpty()) {
            Node curNode = que.poll();

            if(curNode.currency.equals(target))
                return curNode.rate;
            
            visited.add(curNode.currency);
            for(Node neigh: graph.get(curNode.currency)) {
                if(!visited.contains(neigh.currency)){
                    que.offer(new Node(neigh.currency, curNode.rate * neigh.rate));
                }
            }
        }

        return -1.0;
    }


    static class Node {
        String currency;
        double rate;
        public Node(String currency, double rate) {
            this.currency = currency;
            this.rate = rate;
        }
        //todo implement getters setters
    }
    
}



/*
 * 
 * getRate(USD, TRY) -> 17
 * getRate(EUR, USD) -> 1.01
 * getRate(TTT, KKK) -> -1 (doesnt exist)
 * 
 * 
 * Node(currency, rate)
 * 
 * intuition:
 * -create a graph with the data given
 * -bfs from source currency to target currency
 * -there could be more than 1 ways, so bfs will find the shortest path.
 * -each currency must be visited once, so there's gonna be CYCLES
 * 
 * clarifications:
 * -- getRate("", "") -> -1
 * -- how are we getting the data -> String[][]
 * -- 
 * 
 * 
 * 
 * 
 */