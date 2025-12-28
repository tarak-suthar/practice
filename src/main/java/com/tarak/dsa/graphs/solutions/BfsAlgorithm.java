package com.tarak.dsa.graphs.solutions;

import java.util.*;

public class BfsAlgorithm {
    public static int solve(List<List<Integer>> edges, int A) {
        return bfs(edges, A);
    }


    public static int bfs(List<List<Integer>> edges, int A) {

        Map<Integer, List<Integer>> al = new HashMap<>();
        for (int i = 1; i <= A; i++) {
            al.put(i, new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            al.get(u).add(v);
        }

        boolean[] visited = new boolean[A + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited[u] = true;
            for (int v : al.get(u)) {
                if (!visited[v]) queue.offer(v);
            }
        }

        if (visited[A]) return 1;
        return 0;
    }

}
