package com.tarak.dsa.graphs.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MstWithKruskal {
    public static List<List<Integer>> run(int[][] edges, int n) {
        System.out.println("Running MST with Kruskal's Algorithm...");
        // Implementation of Kruskal's algorithm would go here

        return solve(edges,n);
    }

    private static List<List<Integer>> solve(int[][] edges, int n) {
        // sort the edges based on weight
        Arrays.sort(edges, (a, b) -> {
            return a[2] - b[2];
        });

        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) parent[i] = i;

        List<List<Integer>> result = new ArrayList<>();
        int cost = 0;
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            int pu = findParent(u, parent);
            int pv = findParent(v, parent);

            if(pu == pv) continue;
            cost += w;

            int maxP = Math.max(pu, pv);
            int minP = Math.min(pu, pv);

            parent[maxP] = minP;
            result.add(List.of(u,v,w));
        }
        System.out.println(" total minimum cost: "+ cost);
        return result;
    }

    private static int findParent(int n, int[] parent) {
        if (n == parent[n]) return n;
        return findParent(parent[n], parent);
    }


}
