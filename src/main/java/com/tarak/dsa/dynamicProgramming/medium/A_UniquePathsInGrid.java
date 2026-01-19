package com.tarak.dsa.dynamicProgramming.medium;

import com.tarak.dsa.dynamicProgramming.Method;
import com.tarak.util.Result;

public class A_UniquePathsInGrid {
    /*
    Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m).
    At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).

    Now consider if some obstacles are added to the grids.
    Return the total number unique paths from (1, 1) to (n, m).

    Note:
    1. An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
    2. Given Source Point and Destination points are 1-based index.
     */

    public static void main(String[] args) {
        /*
        1 1 0 0
        1 2 2 0
        0 2 4 4
         */
        int[][] A = {
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0}
        };

        new A_UniquePathsInGrid().solution(A);
    }

    public void solution(int[][] A) {
        Result.print(findUniquePathsInGrid(A, Method.TABULATION));
    }

    private int findUniquePathsInGrid(int[][] A, Method type) {
        if (type == Method.TABULATION) return tabulation(A);
        return 0;
    }

    private int tabulation(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[n][m];

        if (A[0][0] == 1 || A[n - 1][m - 1] == 1) return 0;

        for (int i = 0; i < n; i++) {
            if (A[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (A[0][i] == 1) break;
            dp[0][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) dp[i][j] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (A[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[n - 1][m - 1];
    }


}
