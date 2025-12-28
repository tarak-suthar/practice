package com.tarak.dsa.graphs.solutions;

import java.util.*;

public class MinimumCostToReachSToD {
    // in a weighted graph find minimum cost to reach Source to Destination

    public static int solve(int[][] edges, int src, int des, int n) {
        Map<Integer, List<Pair>> al = new HashMap<>();
        for (int i = 0; i < n; i++) al.put(i, new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            al.get(u).add(new Pair(v, w));
        }

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(src, 0));
        cost[src] = 0;
        while (!queue.isEmpty()) {
            Pair u = queue.poll();

            for (Pair v : al.get(u.node)) {
                int c = u.weight + v.weight;
                if (c < cost[v.node]) {
                    cost[v.node] = c;
                    queue.offer(new Pair(v.node, c));
                }
            }

        }

        return cost[des];
    }

    private static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
