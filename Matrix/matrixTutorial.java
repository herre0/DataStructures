package com.mert.Matrix;

public class matrixTutorial {
    


    public static void main(String[] args) {
        
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};


        /* iteration */
        

        int nums[] = {1,2,3,4,5,6,7,8,9};
        int myMatrix[][] = new int[3][3];
        int arrIndex = 0;
        for(int row= 0; row < myMatrix.length; row++) {
            for (int col = 0; col<myMatrix.length; col++) {
                myMatrix[row][col] = nums[arrIndex++];
            }
        }

        printMatrix(myMatrix);

        



    }

    public static void printMatrix(int[][] matrix) {
        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                System.out.print(matrix[r][c]);
            }
            System.out.print("\n");       
        }
    }

}
