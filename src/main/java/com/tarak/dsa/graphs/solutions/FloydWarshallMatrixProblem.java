package com.tarak.dsa.graphs.solutions;

public class FloydWarshallMatrixProblem {
    public static int[][] solve(int[][] A) {
        // given if i==j A[i][j] = 0
        // if no edge A[i][j] = -1;
        int n = A.length;
        int[][][] dp = new int[n + 1][n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i + 1][j + 1][k] = A[i][j];
                }
            }
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                for (int k = 1; k <= n; k++) {
                    int first = Integer.MAX_VALUE;
                    int second = Integer.MAX_VALUE;
                    /*
                      {  1   2   3
                       1 {0, 50, 39},
                       2 {-1, 0, 1},
                       3 {-1, 10, 0}
                      }

                      0 -> 1 = 50, 0 -> 1 using 1 =

                     */
                    if (dp[i][j][k - 1] != -1) {
                        first = dp[i][j][k - 1];
                    }
                    if (dp[i][k - 1][k - 1] != -1 && k != i && dp[k - 1][j][k - 1] != -1 && k != j) {
                        second = dp[i][k][k - 1] + dp[k][j][k - 1];
                    }
                    if (first == Integer.MAX_VALUE && second == Integer.MAX_VALUE) dp[i][j][k] = -1;

                    else {
                        System.out.print("check: i:" + i + " j:" + j + " k:" + k + " -> " + first + " <> " + second + "| ");
                        dp[i][j][k] = Math.min(first, second);
                    }
                }
            }
        }

        int[][] ans = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = dp[i+1][j+1][n];
            }
        }

        return ans;
    }
}
