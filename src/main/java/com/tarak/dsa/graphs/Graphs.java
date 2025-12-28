package com.tarak.dsa.graphs;

public interface Graphs {
    int[][] undirectedCyclicGraph = {
            {1, 2},
            {2, 3},
            {2, 4},
            {3, 5},
            {4, 6},
            {1, 6},
            {6, 7}
    };

    /*

     */
    int[][] directedCyclicGraph = {
            {1, 2},
            {4, 1},
            {2, 4},
            {3, 4},
            {5, 2},
            {1, 3}
    };

    int[][] directedAcyclicGraph = {
            {1, 4},
            {1, 2},
            {3, 5},
            {3, 5},
            {2, 3}
    };

    int[][] undirectedDisconnectedGraph = {
            {1, 2}, {1, 4}, {2, 4}, {2, 3}, {5, 6}, {6, 7}
    };


    /*
    [0,1,9],[0,2,3],[2,1,4],[2,3,8],[1,4,6],[2,4,2],[4,5,11],[3,5,4]
     */
    int[][] undirectedWeightedGraphFindMST = {
            {0, 1, 9},
            {0, 2, 3},
            {2, 1, 4},
            {2, 3, 8},
            {1, 4, 6},
            {2, 4, 2},
            {4, 5, 11},
            {3, 5, 4}
    };
}
