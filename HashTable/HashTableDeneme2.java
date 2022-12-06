package com.mert.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// increase size & dbl Hashing
public class HashTableDeneme2 {
    String[] table;
    int size;

    HashTableDeneme2(int size) {
        this.size = size;
        table = new String[size];
        fillTableWithNeg1();
    }

    public static void main(String[] args) {
        HashTableDeneme2 hashTable = new HashTableDeneme2(30);//loadFactor should not be high like 0.7 0.8
        String[] keys = {"100", "510", "170", "214", "268", "398", "235", "802", "900"};//9

        hashTable.doubleHashFunc(keys);
        hashTable.displayTheStack(hashTable.table);
        hashTable.findKeyDblHashed("170");
        hashTable.findKeyDblHashed("510");
        hashTable.findKeyDblHashed("233");

 

    }

    void doubleHashFunc(String[] keys) {
        for(int i = 0; i < keys.length; i++) {
            String key = keys[i];
            int indexHash = Integer.parseInt(key) % size;
            int stepDistance = Integer.parseInt(key) % 7;
            System.out.println("Modulus Index= " + indexHash + " for value "+ key);

            while(!table[indexHash].equals("-1")) {
                indexHash += stepDistance;
                System.out.println("Collision Try " + indexHash + " Instead");
                indexHash %= size;
            }
            table[indexHash] = key;
        }
    }

    void findKeyDblHashed(String key) {
        int indexHash = Integer.parseInt(key) % size;
        int stepDistance = Integer.parseInt(key) % 7;

        while(!table[indexHash].equals("-1")) {
            if(table[indexHash].equals(key)) {
                System.out.println("key " + key +" is found at index " + indexHash);
                return;
            }

            indexHash+= stepDistance;
            indexHash %= size;
        }
        System.out.println("Key is not found!");
    }

    void increaseTableSize(int newSize) {
        String[] cleanArray = getLeanTable();
        table = new String[newSize];
        size = newSize;
        fillTableWithNeg1();
        hashFunction1(table);
    }

    void hashFunction1(String[] values) {
        for (int i = 0; i < values.length; i++) {
            String value = values[i];

            int tableIndex = Integer.parseInt(value) % size;

            while (table[tableIndex] != "-1") {
                tableIndex++;
                tableIndex %= size;
            }
            table[tableIndex] = value;
        }
    }

    String[] getLeanTable() {
        ArrayList<String> stringList = new ArrayList<>();
        for (String s : stringList)
            if (s.equals("-1") || s.equals(""))
                stringList.add(s);

        return stringList.toArray(new String[stringList.size()]);
    }


    void fillTableWithNeg1() {
        Arrays.fill(table, "-1");
    }

    public void displayTheStack(String[] theArray) {
        int increment = 0;
        for (int m = 0; m < theArray.length / 10; m++) {

            increment += 10;

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {
                System.out.format("| %3s " + " ", n);
            }
            System.out.println("|");
            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();
            for (int n = increment - 10; n < increment; n++) {
                if (theArray[n].equals("-1"))
                    System.out.print("|      ");
                else
                    System.out.print(String.format("| %3s " + " ", theArray[n]));
            }
            System.out.println("|");
            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();
        }
    }

}
