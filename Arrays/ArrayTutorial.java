package com.mert.Arrays;

public class ArrayTutorial {

    public static void main(String[] args) {
        int nums[] = new int[10];// declaring and allocating the memory to array
        int[] nums2 = new int[10];// same way with the above
        int[] nums1 = new int[]{1, 2, 3, 4, 5, 6};//older one
        int[] arr = {1, 2, 3, 4, 5, 6};// new one
        byte byteArray[];
        short shortsArray[];
        boolean booleanArray[];
        long longArray[];
        float floatArray[];
        double doubleArray[];
        char charArray[];
        //the elements in the array allocated by new will automatically be initialized to zero(for numveric types)
        // false(boolean types)m, or null (for reference types)

        //todo Accessing the array
        for(int i = 0; i < arr.length; i++)
            System.out.println("Element at index " + i + ": " + arr[i]);

        for (int num: arr)// For-each loops don't keep track of index
            System.out.println(num);

        Student[] students = new Student[5];
        students[0] = new Student(1, "Mert");
        students[1] = new Student(2, "John");

        // What happens if we try to access element outside the array size?
        //todo JVM throws ArrayIndexOutOfBoundsException
        //nums[10] = 4; // throws exception

        // Multidimensional Arrays :
        // arrays of arrays with each element of the array holding the reference of other array.
        int[][] twoDArray = {{1,2,3}, {9,8,7}, {4,5,6}};
        int[][][] threeDArray = new int[4][4][4];

        for(int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray.length; j++)
                System.out.print(twoDArray[i][j]);
            System.out.println();
        }

        //Passing Arrays to Methods
        sum(arr);
        //Returning Arrays from Methods
        int[] array = getArrayFree();

        // The public final field length, which contains the number of components of the array.
        // length may be positive or zero.
        // All the members inherited from class Object; the only method of Object that is not inherited is its clone method.

        // Cloning of arrays
        // When you clone a single dimensional array a “deep copy” is performed with the new array
        // containing copies of the original array’s elements as opposed to references.
        int[] cloneArray = arr.clone(); // deep copy is created
        System.out.println("is clone same as arr? ->" + (cloneArray == arr));
        int[] copyArray = arr;
        System.out.println("is copy same as arr? ->" + (copyArray == arr));

        int intArray[][] = {{1,2,3},{4,5}};
        int cloneArray2[][] = intArray.clone();
        // prints false because it's a copy
        System.out.println(intArray == cloneArray2);
        // will print true as shallow copy is created
        // i.e. sub-arrays are shared
        System.out.println(intArray[0] == cloneArray2[0]);
        System.out.println(intArray[1] == cloneArray2[1]);
    }

    static void sum(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += nums[i];

        System.out.println("sum : " + sum);
    }

    static class Student {
        int id;
        String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    static int[] getArrayFree() {
        return new int[]{1, 2, 3};
    }


}
