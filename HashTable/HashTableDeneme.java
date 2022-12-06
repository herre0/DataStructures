package com.mert.HashTable;

import java.util.Arrays;

public class HashTableDeneme {
    String[] table;
    int size;

    HashTableDeneme(int size) {
        this.size = size;
        table = new String[size];
        Arrays.fill(table, "-1");
    }

    public static void main(String[] args) {
        HashTableDeneme hashTable = new HashTableDeneme(10);
        String[] values = {"100", "510", "170", "214", "268", "398", "235", "802", "900"};//9

        hashTable.hasFunction1(values);
        hashTable.displayTheStack(hashTable.table);
        hashTable.findKey("268");
        hashTable.findKey("2323");
    }

    void hasFunction1(String[] values) {
        for (int i = 0; i < values.length; i++) {
            String value = values[i];

            int tableIndex = getHashCode(value);

            while (table[tableIndex] != "-1") {
                tableIndex++;
                tableIndex %= size;
            }
            table[tableIndex] = value;
        }
    }

    int getHashCode(String key) {
        return Integer.parseInt(key) % size;
    }

    // key = value, has to be unique
    void findKey(String key) {
        int indexHash = getHashCode(key);
        while (table[indexHash] != "-1") {
            if (table[indexHash].equals(key)) {
                System.out.println("key found at index " + indexHash);
                return;
            }

            indexHash++;
            indexHash %= size;
        }
        System.out.println("Key is not found!");
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
