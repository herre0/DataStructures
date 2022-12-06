package com.mert.Collections;

import com.mert.Algorithms.MergeSort;

import java.util.*;

public class CollectionTutorial {

    public static void main(String[] args) {
        List col = new ArrayList();
        List col2 = new Vector();
        List<Integer> col3 = new LinkedList();
        List<Integer> col4 = new Stack(); // only List interface has get(index)
        col4.add(4);
        col4.add(5);

        Set<String> setList = new HashSet();//don't have get()
        setList.add("mert");
        setList.add("trem");
        for(String s : setList)
            System.out.print(s);
        for(int i : col4)
            System.out.print(i);


        // map is different interface, Hashmap(class) implements it
        Map<Integer, Integer> map = new HashMap();
        HashMap<Integer, String> map2 = new HashMap();
        map2.put(1, "mert");
        map2.put(2, "kabadayi");
        for (Map.Entry<Integer, String> e : map2.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());


        /* Array to arraylist */
        /*1 is using manual loop */
        Integer[] arr = {2, 3, 5, 1, 2};//primitive int won't work
        List<Integer> arrayList = Arrays.asList(arr);
        List<Integer> arrayList2 = List.of(arr);
        for(int i : arrayList)
            System.out.print(i);
        for(int i : arrayList)
            System.out.print(i);

        Integer[] arr2 = arrayList2.toArray(arr);
        for(int i : arr2)
            System.out.print(i);

        System.out.print("\n");
        Arrays.sort(arr);
        for(int i : arr)
            System.out.print(i);

        ArrayList arrayList1 = new ArrayList(setList);


    }


}
