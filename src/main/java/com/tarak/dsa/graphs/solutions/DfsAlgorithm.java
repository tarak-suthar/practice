package com.tarak.dsa.graphs.solutions;

import java.util.List;
import java.util.Map;

public class DfsAlgorithm {
    private int start;
    private Map<Integer, List<Integer>> adjacencyList;
    private int n;

    public DfsAlgorithm(Map<Integer, List<Integer>> adjacencyList, int start, int n) {
        this.adjacencyList = adjacencyList;
        this.start = start;
        this.n = n;
    }

    public void run() {
        boolean[] visited = new boolean[n + 1];
        dfs(start, visited);
    }

    public void dfs(int i, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        System.out.println("visited node: " + i);
        List<Integer> nodes = adjacencyList.get(i);
        for (int node : nodes) {
            dfs(node, visited);
        }
    }
}
