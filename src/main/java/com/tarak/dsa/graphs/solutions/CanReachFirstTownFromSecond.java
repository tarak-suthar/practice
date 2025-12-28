package com.tarak.dsa.graphs.solutions;

import java.util.*;

public class CanReachFirstTownFromSecond {
    public static int solve(int[] A, int B, int C) {
        Map<Integer, List<Integer>> al = new HashMap<>();
        for (int i = 1; i <= A.length; i++) al.putIfAbsent(i, new ArrayList<>());
        for (int i = 1; i < A.length; i++) {
            int u = A[i];
            int v = i + 1;
            al.get(u).add(v);
        }
        boolean[] visited = new boolean[A.length + 1];
//        bfs(C, al, visited);
        dfs(C, al, visited);
        if (visited[B]) return 1;
        return 0;
    }

    public static void dfs(int node, Map<Integer, List<Integer>> al, boolean[] visited) {
        if (visited[node]) return;
        visited[node] = true;
        for (int v : al.get(node)) {
            dfs(v, al, visited);
        }
    }

    public static void bfs(int start, Map<Integer, List<Integer>> al, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited[u] = true;
            for (int v : al.get(u)) {
                if (!visited[v]) queue.offer(v);
            }
        }
    }
}
