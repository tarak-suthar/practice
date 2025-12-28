package com.tarak.dsa.graphs.solutions;

import java.util.Arrays;

public class BellmanFord {
    public static void solve(int[][] edges, int s, int n) {
        // to find the shortest path from source to destination in a graph with negative weights
        // won't work if there is negative cycle in the graph

        // let's say there are n node in the graph
        // then there will be n-1 iteration
        // create n+1 weights array which will eventually be the weights/cost to reach each node from the source node
        // source with weights[source] = 0 else Integer.MAX_VALUE / INFINITY
        // in each iteration we will go through all the edges and
        // try to update weight for each node by calculating weight/cost fron source to that node
        // weights[i] will store the currently known minimum cost to reach from source to ith node
        // by the end/n-1 iterations will get the minimum weight/cost to reach from source to the node for each node
        // Caution: if a given graph has negative cycle than even after n-1 iterations we will notice weights being updated
        /*
        A -> B 10
        B -> D -4
        F -> D 2
        B -> F -2
        A -> C 5
        C -> G 7

            0  ~  ~  ~  ~  ~
            A  B  C  D  F  G
         0  0  10 5  6  8  7
         0  0
         */

        int[] weights = new int[n + 1];
        weights[s] = 0;
        Arrays.fill(weights, Integer.MAX_VALUE);

        boolean flag = false;  // flag to stop with there is not change in weights in an iteration
        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (weights[u] != Integer.MAX_VALUE && weights[v] > (w + weights[u])) {
                    flag = true;
                    weights[v] = w + weights[u];
                }
            }
            if (!flag) return;
        }

        // we can check for negative cycle by doing one more iteration
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[3];

            if (weights[u] != Integer.MAX_VALUE && weights[v] > (w + weights[u])) {
                throw new RuntimeException("Negative cycle detected");
            }
        }
    }
}
