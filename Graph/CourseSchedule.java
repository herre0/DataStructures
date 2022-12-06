package com.mert.Graph;

import java.util.ArrayList;

public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();

        int[][] preTable = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4}};
        // int[][] preTable = {{1, 0}, {0, 1}};
        System.out.print(courseSchedule.canFinish(5, preTable));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        boolean[] dp = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i, dp))
                return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course, boolean[] dp) {
        if (visited[course])
            return dp[course];
        else
            visited[course] = true;

        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, visited, (int) graph[course].get(i), dp))
                return false;
        }

        dp[course] = true;
        return true;
    }

}
