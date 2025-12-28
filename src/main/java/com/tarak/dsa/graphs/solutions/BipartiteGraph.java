package com.tarak.dsa.graphs.solutions;

import java.util.*;

public class BipartiteGraph {
    public static boolean solve(int[][] edges, int A) {
        // approach try to color graph in two colors
        Map<Integer, List<Integer>> al = new HashMap<>();
        for (int i = 0; i < A; i++) {
            al.putIfAbsent(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            al.get(u).add(v);
            al.get(v).add(u);
        }

        int[] colors = new int[A];
        Arrays.fill(colors, -1);

        for (int i = 0; i < A; i++) {
            if (colors[i] == -1) {
                if (!bfs(i, al, colors)) return false;
            }
        }
        return true;
    }

    private static boolean bfs(int start, Map<Integer, List<Integer>> al, int[] colors) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(start, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            System.out.println(" node: " + pair.i);
            colors[pair.i] = pair.color;
            for (int v : al.get(pair.i)) {
                if (colors[v] == colors[pair.i]) return false;
                if (colors[v] == -1) queue.offer(new Pair(v, 1 - colors[pair.i]));
            }
        }
        return true;
    }

    private static class Pair {
        int i;
        int color;

        Pair(int i, int color) {
            this.i = i;
            this.color = color;
        }
    }
}
