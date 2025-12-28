package com.tarak.dsa.graphs.solutions;

import java.util.*;

public class ConnectedComponents {
    public static int solve(List<List<Integer>> edges, int n) {
        Map<Integer, List<Integer>> al = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            al.put(i, new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            al.get(u).add(v);
            al.get(v).add(u);
        }
        boolean[] visited = new boolean[n + 1];
        int components = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                components++;
                bfs(i, al, visited);
            }
        }
        return components;
    }

    private static void bfs(int start, Map<Integer, List<Integer>> al, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited[u] = true;
            for (int v : al.get(u)) {
                if (!visited[v]) bfs(v, al, visited);
            }
        }
    }
}
