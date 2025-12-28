package com.tarak.dsa.graphs.solutions;

public class NumberOfIslands {
    public static int solve(int[][] M) {
        boolean[][] visited = new boolean[M.length][M[0].length];
        int m = M.length;
        int n = M[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && M[i][j] != 0) {
                    System.out.println("|| island start: at (" + i + " " + j + ") ");
                    dfs(i, j, M, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int i, int j, int[][] M, boolean[][] visited) {
        if (i >= M.length || j >= M[0].length || i < 0 || j < 0 || visited[i][j] || M[i][j] == 0) return;
        visited[i][j] = true;
        System.out.println(" <" + i + " " + j + "> ");
        // up
        dfs(i - 1, j, M, visited);
        // down
        dfs(i + 1, j, M, visited);
        // right
        dfs(i, j + 1, M, visited);
        // left
        dfs(i, j - 1, M, visited);
    }
}
