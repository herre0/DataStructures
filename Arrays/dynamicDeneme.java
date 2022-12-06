package com.mert.Arrays;

public class dynamicDeneme {
    int[] array;
    int capacity = 2;
    int length = 0;

    public dynamicDeneme() {
        array = new int[capacity];
    }

    public static void main(String[] args) {
        dynamicDeneme dynamo = new dynamicDeneme();
        dynamo.add(1);
        dynamo.add(2);
        dynamo.add(3);
        dynamo.print();
        dynamo.add(4);
        dynamo.add(5);
        dynamo.print();
        dynamo.removeAt(2);
        dynamo.removeAt(0);
        dynamo.print();
    }

    public void add(int value) {
        if (length >= capacity) {
            capacity *= 2;

            int[] newArr = new int[capacity];

            for (int i = 0; i < length; i++) {
                newArr[i] = array[i];
            }

            array = newArr;
        }
        array[length] = value;
        length++;
    }

    public void removeAt(int index) {
        int[] newArr = new int[length - 1];

        for (int i = 0, j = 0; i < length; i++, j++) {
            if (i == index)
                j--;
            else
                newArr[j] = array[i];
        }
        array = newArr;
        capacity = --length;

    }

    public void print() {
        System.out.print("\n[");

        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("] cap: " + capacity + " len: " + length);
    }


}