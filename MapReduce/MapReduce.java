package com.mert.MapReduce;

import java.util.*;

public class MapReduce {
    HashMap<String, Integer> myMap = new HashMap<>();
    String[] input = { "Deer", "Bear", "River", "Car", "Car", "River",
            "Deer", "Car", "Bear" };

    public MapReduce() {
    }

    public static void main(String[] args) {

        MapReduce mr = new MapReduce();
        List<String> intermediateList = new ArrayList();

        System.out.println("Mapping is on process..");
        intermediateList = mr.map();
        System.out.println("Mapped list:");
        mr.printiList(intermediateList);


        System.out.println("Reducing is on process..");
        mr.reduce(intermediateList);

        System.out.println("-----Final Map:----");
        mr.printMap();
    }

    // read input and produce a set of key-value pairs
    public List<String> map() {
        List<String> returnList = new ArrayList();

        for (int i = 0; i < input.length; i++) {
            returnList.add(input[i] + "#" + "1");
        }

        return returnList;
    }

    public void reduce(List<String> intermediateList) {
        for (String hashedString : intermediateList) {
            String key = hashedString.split("#")[0];
            int value = Integer.valueOf(hashedString.split("#")[1]);

            myMap.put(key, myMap.getOrDefault(key, 0)+1);            
        }
    }

    // reduce(): Collect all values belonging to the key and output

    public void printMap() {
        for (String key : myMap.keySet()) {
            System.out.print(key + " -> " + myMap.get(key) + "\n");
        }
    }

    public void printiList(List<String> list) {
        for (String hashedString : list) {
            String strs[] = hashedString.split("#");
            System.out.print(strs[0] + " -> " + strs[1] + "\n");
        }
    }

}
