package com.mert.Pramp;

public class _06_NumberOfPaths {
    public static void main(String[] args) {
        int n = 4;
        int[][] visited = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = -1;
            }
        }

        System.out.println(dfs(n-1, n-1, visited));
    }

    public static int dfs(int i, int j, int[][] visited) {
        // edge cases
        if(i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || i < j)
            return 0;

        // base case
        if(i == 0 && j == 0)
            return 1;

        if(visited[i][j] != -1)
            return visited[i][j];

        visited[i][j] = dfs(i - 1, j, visited) + dfs(i, j - 1, visited);
        return visited[i][j];
    }

}


// takeaways:
/*
 * 1- study x-y indexes on grid
 * 2- solve fibonacci type dynamic programming questions
 * 
 */


/*
 * https://www.pramp.com/challenge/N5LYMbYzyOtbpovQoY7X
 * input:  n = 4

output: 5 # since there are five possibilities:
          # “EEENNN”, “EENENN”, “ENEENN”, “ENENEN”, “EENNEN”,
          # where the 'E' character stands for moving one step
          # East, and the 'N' character stands for moving one step
          # North (so, for instance, the path sequence “EEENNN”
          # stands for the following steps that the car took:
          # East, East, East, North, North, North)
 */