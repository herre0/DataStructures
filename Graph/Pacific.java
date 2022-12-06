package com.mert.Graph;

import java.util.*;


public class Pacific {

    public static void main(String[] args) {
       

        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};

        List<List<Integer>> res = new LinkedList<>();
        
        int rows = matrix.length, cols = matrix[0].length;
        
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        // first column and last column
        for(int i=0; i < rows; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, cols-1);
        }
        
        // first row and last row
        for(int i=0; i<cols; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, rows-1, i);
        }
        
        
        for (int i = 0; i < rows; i++) 
            for (int j = 0; j < cols; j++) 
                if (pacific[i][j] && atlantic[i][j]) 
                    res.add(Arrays.asList(i, j));
        
        
        System.out.println(res);
    } 

    public static void dfs(int[][] matrix, boolean[][] visited, int height, int r, int c){        
        if(r<0 || r >= matrix.length || c < 0 || c >= matrix[0].length || visited[r][c] || matrix[r][c] < height)
            return;
        
        visited[r][c] = true;
        
        dfs(matrix, visited, matrix[r][c], r, c + 1); 
        dfs(matrix, visited, matrix[r][c], r, c - 1);
        dfs(matrix, visited, matrix[r][c], r + 1, c);
        dfs(matrix, visited, matrix[r][c], r - 1, c);
    }

    
}
