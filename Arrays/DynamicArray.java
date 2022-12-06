package com.mert.Arrays;

public class DynamicArray {

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray(2);

        dynamicArray.add(15);
        dynamicArray.add(20);
        dynamicArray.add(25);
        System.out.println(dynamicArray.toString());
        dynamicArray.add(30);
        dynamicArray.indexOf(25);
        dynamicArray.contains(20);
        dynamicArray.removeAt(0);
        dynamicArray.remove(20);
        System.out.println(dynamicArray.toString());
    }

    private int[] arr;
    private int len = 0; // length user thinks array is
    private int capacity = 0;//actual array size

    public DynamicArray(int capacity) {
        if(capacity < 0) throw new IllegalArgumentException("Illegal Capacity : " + capacity);
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public void add(int val) {
        if(len + 1 >= capacity) {
            if(capacity == 0)
                capacity = 1;
            else
                capacity *= 2;
            int[] new_arr = new int[capacity];
            for(int i = 0;i < len; i++)
                new_arr[i] = arr[i];

            arr = new_arr;
        }
        arr[len++] = val;
    }

    public int removeAt(int index) {
        if(index >= len || index < 0) throw new IndexOutOfBoundsException();

        int data = arr[index];
        int[] new_arr = new int[len - 1];
        for(int i = 0, j = 0; i < len; i++, j++)
            if (i == index)
                j--;
            else
                new_arr[j] = arr[i];
        arr = new_arr;
        capacity = --len;
        return data;
    }

    public int indexOf(int val) {
        for(int i = 0; i < len; i++)
           if(val == arr[i]) return i;

        return -1;
    }

    public boolean remove(int val) {
        int index = indexOf(val);
        if(index == -1) return false;
        removeAt(index);
        return true;
    }

    public boolean contains(int val) {
        return indexOf(val) != -1;
    }

    @Override
    public String toString() {
        if(len == 0)
            return "[]";
        else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for(int i = 0; i < len - 1; i++)
                sb.append(arr[i] + ", ");

         return sb.append(arr[len - 1] + "]").toString();
        }
    }

}
