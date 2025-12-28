package com.tarak.dsa.graphs.solutions;

import java.util.*;

public class LexoGraphicallyTopologicalSort {
    public static void solve(int[][] edges, int n) {
        Map<Integer, List<Integer>> al = new HashMap<>();
        for (int i = 1; i < n + 1; i++) al.put(i, new ArrayList<>());
        int[] indegree = new int[n + 1];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            indegree[v]++;
            al.get(u).add(v);
        }
        Queue<Integer> queue = new PriorityQueue<>(new Comp());
        for (int i = 1; i < n + 1; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        System.out.println(" Start =>");
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.println(" "+u);
            for (int v : al.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) queue.offer(v);
            }
        }
    }

    public static class Comp implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return a - b;
        }
    }
}
