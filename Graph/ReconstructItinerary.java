package com.mert.Graph;

import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args) {
        String[][] tickets = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
        String[][] tickets2 = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};


        findItinerary(tickets2);
        System.out.println(result);
    }
    static HashMap<String, LinkedList<String>> flightMap = new HashMap<>();
    static LinkedList<String> result = new LinkedList();

    public static List<String> findItinerary(String[][] tickets) {
        // Step 1). build the graph first
          
        for(String[] ticket: tickets) {
          String source = ticket[0];
          String dest = ticket[1];
          if (flightMap.containsKey(source)) 
            flightMap.get(source).add(dest);
           else {
            LinkedList<String> destList = new LinkedList();
            destList.add(dest);
            flightMap.put(source, destList);
          }
        }
    
        // Step 2). order the destinations
        flightMap.forEach((key, value) -> Collections.sort(value));
    
        // Step 3). post-order DFS
        DFS("JFK");
        return result;
      }
    
      public static void DFS(String origin) {
        // Visit all the outgoing edges first.
        if (flightMap.containsKey(origin)) {
          LinkedList<String> destList = flightMap.get(origin);
          while (!destList.isEmpty()) {
            // while we visit the edge, we trim it off from graph.
            String dest = destList.pollFirst();
            DFS(dest);
          }
        }
        // add the airport to the head of the itinerary
        result.offerFirst(origin);
      }

    
}
