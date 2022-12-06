package com.mert.Graph;

import java.util.*;

public class CurrencyCalc3 {
    static HashMap<String, List<Node>> graph= new HashMap();
    public static void main(String[] args) {        
        

        // [from, to, rate]
        String[][] currencies = {
            {"USD", "TRY", "18.40"},
            {"USD", "EUR", "1.02"},
            {"TRY", "JPY", "7.73"},
            {"JPY", "GBP", "0.0063"},
            {"GBP", "CAD", "1.51"},
            {"EUR", "CAD", "1.32"}
        };

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

        System.out.println(getRate("USD", "CAD"));
        System.out.println(getRate("USD", "GBP"));
        System.out.println(getRate("EUR", "TRY"));
        System.out.println(getRate("USD", "TTT"));
        System.out.println(getRate("TRY", "USD"));
    }
    // bfs
    public static double getRate(String cur1, String cur2) {
        Queue<Node> que = new LinkedList();
        que.offer(new Node(cur1, 1));
        HashSet<String> visited = new HashSet();

        while(!que.isEmpty()) {
            Node curNode = que.poll();

            if(curNode.node.equals(cur2))
                return curNode.rate;
            
            if(visited.contains(curNode.node))
                continue;
            visited.add(curNode.node);

            for(Node neigh: graph.get(curNode.node)) {
                if(!visited.contains(neigh.node))
                    que.offer(new Node(neigh.node, neigh.rate * curNode.rate));
            }
        }

        return -1;
    }

    static class Node {
        String node;
        double rate;
        public Node(String node, double rate) {
            this.node = node;
            this.rate = rate;
        }
    }

}

/*
 * 
 * getRate(USD, TRY) -> 18.94
 * getRate(TRY, USD) -> 1/18.94
 * getRate(USD, KKK) -> -1 (doesn't exist)
 * 
 * 
 */
