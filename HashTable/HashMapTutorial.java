package com.mert.HashTable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.TreeMap;

public class HashMapTutorial {

    public static void main(String[] args) {

        // see the differences in notes. 
    // Main difference is map can have null values
    HashMap<String, Integer> map = new HashMap();
    // it is initial capacity
    // initial capacity is 16 and load factor is 0.75 in default 
    HashMap<String, Integer> mapWithCapacity = new HashMap(10);
    Hashtable<String, Integer> hashTable = new Hashtable();



    map.put("mert", 23);
    map.put("Bill", 75);
    map.put("Elon", 45);
    map.put("Steve", 67);
    map.put("Gary", 44);

    if(map.containsKey("mert"))
        System.out.println("the age of Mert is " + map.get("mert"));

    System.out.println(map.getOrDefault("herre", 80));

    System.out.println("Hash Map: \n" + map);


    for(String key: map.keySet()){
        System.out.println(key + " -> " + map.get(key));
    }
    
    Collection<Integer> vals = map.values();
    for(Integer val: vals){
        System.out.print(val + ", ");
    }
    System.out.print("\n");

    map.remove("Gary");
    map.put("Steve", 666);
    System.out.println("Hash Map: \n" + map);

    System.out.println("is MAp Empty? :" + map.isEmpty());
    System.out.println("contains 45 as value? :" + map.containsValue(45));
    System.out.println("HashMap size :" + map.size());

    TreeMap<Integer, String> tmap = new TreeMap();//keys will always be sorted 

    tmap.put(50, "Paris");
    tmap.put(7, "New York");
    tmap.put(10, "California");
    tmap.put(34, "Istanbul");

    System.out.println(tmap);

    }

}
