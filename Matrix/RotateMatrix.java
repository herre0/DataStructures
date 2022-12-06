package com.mert.Matrix;

public class RotateMatrix {

    public static void main(String[] args) {
        int a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotatematrix(3, 3, a);
        printMatrix(3, 3, a);
    }


    // Initially, m = R and n = C
    static void rotatematrix(int rLen, int cLen, int mat[][]) {
        int row = 0, col = 0;
        int prev, curr;

        while (row < rLen && col < cLen) {
            if (row + 1 == rLen || col + 1 == cLen)
                break;

            // Store the first element of next
            // row, this element will replace
            // first element of current row
            prev = mat[row + 1][col];

            // Move elements of first row
            // from the remaining rows
            for (int i = col; i < cLen; i++) {
                curr = mat[row][i];
                mat[row][i] = prev;
                prev = curr;
            }
            row++;

            // Move elements of last column
            // from the remaining columns
            for (int i = row; i < rLen; i++) {
                curr = mat[i][cLen - 1];
                mat[i][cLen - 1] = prev;
                prev = curr;
            }
            cLen--;

            // Move elements of last row
            // from the remaining rows
            if (row < rLen) {
                for (int i = cLen - 1; i >= col; i--) {
                    curr = mat[rLen - 1][i];
                    mat[rLen - 1][i] = prev;
                    prev = curr;
                }
            }
            rLen--;

            // Move elements of first column
            // from the remaining rows
            if (col < cLen) {
                for (int i = rLen - 1; i >= row; i--) {
                    curr = mat[i][col];
                    mat[i][col] = prev;
                    prev = curr;
                }
            }
            col++;
        }
    }

    public static void printMatrix(int r, int c, int[][] matrx) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                System.out.print(matrx[i][j] + " ");
            System.out.print("\n");
        }
    }
}
