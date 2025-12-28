package com.tarak.dsa.graphs.solutions;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static int solve(int[][] M) {
        // start with rotten orange bfs to fresh oranges
        // keep the max time till every orange is rotten
        int m = M.length;
        int n = M[0].length;
        int[][] time = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                time[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 2) bfs(i, j, m, n, M, time);
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (time[i][j] != Integer.MAX_VALUE) ans = Math.max(ans, time[i][j]);
            }
        }
        if (ans == Integer.MIN_VALUE) return -1;
        return ans;
    }

    private static void bfs(int i, int j, int m, int n, int[][] M, int[][] time) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j, 0));
        while (!queue.isEmpty()) {
            Pair u = queue.poll();
            if (u.i < 0 || u.i >= m || u.j < 0 || u.j >= n || M[u.i][u.j] == 0) continue;
            if (u.time >= time[u.i][u.j]) continue;
            System.out.println(" time: " + u.time + " reaching ij: <" + u.i + " " + u.j + "> |");
            time[u.i][u.j] = u.time;
            // top
            queue.offer(new Pair(u.i - 1, u.j, u.time + 1));
            // down
            queue.offer(new Pair(u.i + 1, u.j, u.time + 1));
            // right
            queue.offer(new Pair(u.i, u.j + 1, u.time + 1));
            // left
            queue.offer(new Pair(u.i, u.j - 1, u.time + 1));

        }
    }

    private static class Pair {
        int i;
        int j;
        int time;

        Pair(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }
}
