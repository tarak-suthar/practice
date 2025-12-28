package com.tarak.dsa.graphs.solutions;

import java.util.*;

public class TopologicalSort {
    public static void solve(int[][] edges, int n) {
        Map<Integer,List<Integer>> al = new HashMap<>();
        for(int i = 1;i<=n;i++) al.put(i,new ArrayList<>());
        int[] indegree = new int[n+1];
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            indegree[v]++;
            al.get(u).add(v);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1;i<=n;i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        System.out.println(" order =>");
        while(!queue.isEmpty()){
            int u = queue.poll();
            System.out.println(" "+u);
            for(int v : al.get(u)){
                indegree[v]--;
                if(indegree[v] == 0) queue.offer(v);
            }
        }
    }
}
