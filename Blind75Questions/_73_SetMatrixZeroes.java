package com.mert.Blind75Questions;

import java.util.ArrayList;
import java.util.List;

public class _73_SetMatrixZeroes {

    public static void main(String[] args) {
        int nums[][] = {{1,1,1}, {1, 0, 1}, {1, 1, 1}};

        setZeroes(nums);
    }

    public static void setZeroes(int[][] matrix) {
        List <Integer> rowIndex = new ArrayList<>();
        List <Integer> columnIndex = new ArrayList<>();
        // Now Iterate Over the Array and store the Indices of Zeros in Lists
        for(int row = 0; row < matrix.length; row++){
            for(int column = 0; column < matrix[row].length ; column++){
                if(matrix[row][column] == 0){
                    rowIndex.add(row);
                    columnIndex.add(column);
                }
            }
        }
        // Now set Zeros in ROWS and COLUMNS where 0 Found
        // SET Complete ROW to 0 for Each rowIndex
        for(int i= 0; i < rowIndex.size(); i++){    // Iterate over rowIndex List for getting Index of ROWS
            int row = rowIndex.get(i);              // Store row index in row variable
            for(int j=0; j< matrix[row].length; j++){  // j --> Counter for Iterate over different COLUMNS of the same ROW
                matrix[row][j] = 0;     // set Elements to 0
            }
        }

        // Now SET Complete COLUMN to 0 for Each columnIndex
        for(int i=0; i<columnIndex.size(); i++){ // Iterate over columnIndex List for getting Index of COLUMNS
            int column = columnIndex.get(i);
            for(int j = 0; j< matrix.length; j++){   // for Different ROWS set that column to 0
                matrix[j][column] = 0;    // Set Elements to 0
            }
        }

    }


}
