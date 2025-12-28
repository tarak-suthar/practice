package com.tarak.dsa.graphs.solutions;

import java.util.*;

public class MstWithPrims {
    public static int run(int[][] edges, int n) {

        return solve(edges, n);
    }

    private static int solve(int[][] edges, int n) {
        boolean[] visited = new boolean[n + 1];
        Map<Integer, List<Pair>> al = new HashMap<>();
        for (int i = 0; i < n + 1; i++) al.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            al.get(u).add(new Pair(v, w));
            al.get(v).add(new Pair(u, w));
        }

        Queue<Pair> queue = new PriorityQueue<>(new Comp());
        queue.offer(new Pair(0, 0));
        int cost = 0;
        while (!queue.isEmpty()) {
            Pair u = queue.poll();
            if(!visited[u.node])cost += u.wight;
            visited[u.node] = true;
            for (Pair v : al.get(u.node)) {
                if (!visited[v.node]) {
                    queue.offer(new Pair(v.node,v.wight));
                }
            }
        }

        return cost;
    }

    private static class Comp implements Comparator<Pair> {
        @Override
        public int compare(Pair a, Pair b) {
            return a.wight - b.wight;
        }
    }

    private static class Pair {
        int node;
        int wight;

        Pair(int node, int weight) {
            this.node = node;
            this.wight = weight;
        }
    }
}
