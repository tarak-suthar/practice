package com.tarak.dsa.graphs;

import com.tarak.dsa.graphs.solutions.*;

import java.util.*;

public class Index {

    public static void main(String[] args) {
        Index index = new Index();
//        new Index().problem1();
//        new Index().problem2();
//        index.problem3();
//        index.problem4();
//        index.problem5();
//        index.problem6();
//        index.problem7();
//        index.problem8();
//        index.problem9();
//        index.problem10();
//        index.problem11();
        index.problem12();

    }

    // DFS implementation
    public void problem1() {
        int[][] edges = {
                {1, 2},
                {2, 3},
                {2, 4},
                {3, 5},
                {4, 6},
                {1, 6},
                {6, 7}
        };
        /*
         *                1
         *              /  |
         *            2    |
         *           / \   |
         *          3   4  |
         *          |    \ |
         *          5      6
         *                 |
         *                 7
         * */

        // create adjacency list
        Map<Integer, List<Integer>> al = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            al.putIfAbsent(u, new ArrayList<>());
            al.putIfAbsent(v, new ArrayList<>());
            // undirected graph
            al.get(u).add(v);
            al.get(v).add(u);
        }

        new DfsAlgorithm(al, 1, 7).run();
    }

    // BFS implementation
    public void problem2() {
        /*[  [1, 2]
        [4, 1]
        [2, 4]
        [3, 4]
        [5, 2]
        [1, 3] ]*/
        // directed graph
        List<List<Integer>> edges1 = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 2), Arrays.asList(4, 1), Arrays.asList(2, 4), Arrays.asList(3, 4), Arrays.asList(5, 2), Arrays.asList(1, 3)
        ));


        int target = 5;
        int start = 1;

        int value = BfsAlgorithm.solve(edges1, target);
        System.out.println(value + "======");
    }

    // No of connected components in an undirected graph
    public void problem3() {
        /*
          edges  [1,2],[1,4],[2,4],[2,3],[5,6],[6,7]
        */

        List<List<Integer>> edges = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 2)),
                new ArrayList<>(Arrays.asList(1, 4)),
                new ArrayList<>(Arrays.asList(2, 4)),
                new ArrayList<>(Arrays.asList(2, 3)),
                new ArrayList<>(Arrays.asList(5, 6)),
                new ArrayList<>(Arrays.asList(6, 7))
        ));

        int n = ConnectedComponents.solve(edges, 7);
        System.out.println("No of Connected Components: " + n);
    }

    public void problem4() {
        // directed graph
        // edge from A[i] -> i+1
        // 1 <= i < N
        // value of A[0] is irrelevant
        int[] A = new int[]{1, 1, 2};
        int B = 2;
        int C = 1;
        // A
        // edges
        // 1 -> 1
        // 1 -> 2
        // 2 -> 3
        int ans = CanReachFirstTownFromSecond.solve(A, B, C);
        System.out.println("ans: " + ans);
    }

    public void problem5() {
        // matrix
        int[][] M = new int[][]{
                new int[]{1, 1, 0, 0, 1},
                new int[]{0, 1, 0, 1, 0},
                new int[]{1, 0, 0, 1, 1},
                new int[]{1, 1, 0, 0, 0},
                new int[]{1, 0, 1, 1, 1}
        };

        int ans = NumberOfIslands.solve(M);
        System.out.println(" number of islands: " + ans);
    }

    public void problem6() {
        // matrix
        int[][] M = new int[][]{
                new int[]{2, 1, 1},
                new int[]{1, 1, 0},
                new int[]{0, 1, 1}
        };

        int ans = RottenOranges.solve(M);
        System.out.println("ans: " + ans);
    }

    public void problem7() {
        int[][] edges = new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{1, 2}
        };

        int A = 3;

        boolean ans = BipartiteGraph.solve(edges, A);

        System.out.printf(" is graph bipartite: " + ans);

    }

    public void problem8() {
        int[][] edges = Graphs.directedAcyclicGraph;
        int n = 5;

        TopologicalSort.solve(edges, n);
    }

    public void problem9() {
        int[][] edges = Graphs.directedAcyclicGraph;
        int n = 5;

        LexoGraphicallyTopologicalSort.solve(edges, n);
    }

    // MST
    public void problem10() {
        int[][] edges = Graphs.undirectedWeightedGraphFindMST;
        int n = 6;
        List<List<Integer>> ans = MstWithKruskal.run(edges, n);
        System.out.println(" ans: " + ans);
    }

    public void problem11() {
        int[][] edges = Graphs.undirectedWeightedGraphFindMST;
        int n = 6;
        System.out.println(" MST cost: " + MstWithPrims.run(edges, n));
    }

    public void problem12() {
        int[][] A = {
                {0, 50, 39},
                {-1, 0, 1},
                {-1, 10, 0}
        };

        // [0 5 8 9 ] [-1 0 3 4 ] [-1 -1 0 1 ] [-1 -1 -1 0 ]
        int[][] A2 = {
                {}
        };

        int[][] ans = FloydWarshallMatrixProblem.solve(A);

        for(int i = 0;i<ans.length;i++){
            System.out.printf(Arrays.toString(ans[i]));
        }
    }
}
