package com.mert.Matrix;

public class RotateMatrixby90 {

    public static void main(String[] args) {
        int a[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotatematrix(3, a);
        printMatrix(3, 3, a);
    }


    // Initially, m = R and n = C
    static void rotatematrix(int N, int mat[][]) {
        for (int x = 0; x < N / 2; x++) {
            // Consider elements in group
            // of 4 in current square
            for (int y = x; y < N - x - 1; y++) {
                // Store current cell in
                // temp variable
                int temp = mat[x][y];

                // Move values from right to top
                mat[x][y] = mat[y][N - 1 - x];
                // Move values from bottom to right
                mat[y][N - 1 - x]= mat[N - 1 - x][N - 1 - y];
                // Move values from left to bottom
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];
                // Assign temp to left
                mat[N - 1 - y][x] = temp;
                printMatrix(3, 3, mat);
            }
        }
    }

    public static void printMatrix(int r, int c, int[][] matrx) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++)
                System.out.print(matrx[i][j] + " ");
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
