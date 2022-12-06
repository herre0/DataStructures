package com.mert.Graph;

import java.util.*;
import java.util.List;

public class MyCurrencyCalc {
    public static void main(String[] args) {
        HashMap<String, List<Node>> graph = new HashMap();
        
        String[][] currencies = {
            {"USD", "TRY", "18.40"},
            {"USD", "EUR", "1.02"},
            {"TRY", "JPY", "7.73"},
            {"JPY", "GBP", "0.0063"},
            {"GBP", "CAD", "1.51"},
            {"EUR", "CAD", "1.32"}
    };

        // create graph of currencies
        for(String[] currency: currencies) {

            String source = currency[0];
            String target = currency[1];
            double rate = Double.valueOf(currency[2]);
            if(!graph.containsKey(source))
                graph.put(source, new ArrayList());
            if(!graph.containsKey(target))
                graph.put(target, new ArrayList());
            
            graph.get(source).add(new Node(target, rate));
            graph.get(target).add(new Node(source, 1/rate));
        }
        

        System.out.println(getRate(graph, "USD", "CAD"));
        System.out.println(getRate(graph, "USD", "GBP"));
        System.out.println(getRate(graph, "EUR", "TRY"));
        System.out.println(getRate(graph, "USD", "TTT"));
        System.out.println(getRate(graph, "TRY", "USD"));
    }

    // bfs
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
                    que.offer(new Node(neigh.currency, neigh.rate * curNode.rate));
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
        //todo implement getters settters
    }
}



/*
 * 
 * getRate(USD, TRY) -> 17
 * getRate(EUR, USD) -> 1.05
 * 
 * 
 * intuition:
 * -generate the data
 * -search on data from source to target
 * -graph representation
 * 
 * 
 * Node(currency, rate)
 * 
 * USD: [[TRY, 17], [EUR, 1/1.05]]
 * TRY: [[USD, 1/17]]
 * EUR: [[USD, 1.05]]
 * 
 * 
 * getRate(USD, TRY) 
 * --run dfs from USD's children
 * -- find target currency, return its rate
 * 
 */
