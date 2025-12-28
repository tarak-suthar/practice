package com.tarak.dsa.graphs.solutions;

public class FloydWarshall {
    public static void solve(int[][] edges, int n) {
        // Floyd warshall algorithm is used to find the shortest path from every node to every other node
        // this too like Bellman ford won't work if there is a negative cycle in the grap


        // here dp[i][j][x] -> here i is the source node, j is the destination and x is the count of nodes utilized to reach form source to destination
        // for dp[i][j][0] which represents a direct edge from i to j
        /*
                to find dp[i][j][k]
                /         \
   Min(  dp[i][j][k-1] or dp[i][k][k-1] + dp[k][j][k-1] )


         */
        int[][][] dp = new int[n + 1][n + 1][n + 1];


        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];


            dp[u][v][0] = w;
            // dp[v][u] = w if not directed
        }

        // assuming the graph isn't zero indexed
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                for (int k = 1; k <= n; k++) {
                    dp[i][j][k] = Math.min(dp[i][j][k - 1], dp[i][k][k - 1] + dp[k][j][k - 1]);
                }
            }
        }
    }
}
