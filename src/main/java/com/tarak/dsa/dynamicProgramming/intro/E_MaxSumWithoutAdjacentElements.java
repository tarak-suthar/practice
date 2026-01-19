package com.tarak.dsa.dynamicProgramming.intro;

import com.tarak.dsa.dynamicProgramming.Method;
import com.tarak.util.Result;

import java.util.Arrays;

public class E_MaxSumWithoutAdjacentElements {

    /**
     * Given a 2 x N grid of integers, A, your task is to choose numbers from the grid such that sum of these numbers is maximized.
     * However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally.
     * <p>
     * Return the maximum possible sum.
     * <p>
     * Note: You are allowed to choose more than 2 numbers from the grid.
     */
    public static void main(String[] args) {

        int[][] grid1 = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5}
        };

        /**
         * brute force: for each i from 0 to n, calculate max sum from j = i to 0 with decrementing j by 2 each time;
         * TC: N^2
         */
        /**
         *
         */

        new E_MaxSumWithoutAdjacentElements().solution(grid1);
    }

    private void solution(int[][] grid) {
        Result.print(findMaxSumWithoutAdjacentElements(grid, Method.MEMOIZATION));
        Result.print(findMaxSumWithoutAdjacentElements(grid, Method.TABULATION));
    }

    private int findMaxSumWithoutAdjacentElements(int[][] grid, Method method) {
        if (method.equals(Method.TABULATION)) return tabulation(grid);
        else return memoization(grid);
    }


    private int tabulation(int[][] grid) {
        int[] dp = new int[grid.length];
        dp[0] = Math.max(grid[0][0], grid[0][1]);
        dp[1] = Math.max(grid[1][0], grid[1][1]);
        for (int i = 2; i < grid.length; i++) {
            dp[i] = dp[i - 2] + Math.max(grid[i][0], grid[i][1]);
        }

        return Math.max(dp[grid.length - 1], dp[grid.length - 2]);
    }

    private int memoization(int[][] grid) {
        int[] dp = new int[grid.length + 1];
        Arrays.fill(dp, -1);
        return memoization(grid.length, grid, dp);
    }

    private int memoization(int n, int[][] grid, int[] dp) {
        if (n == 0) return 0;
        if(n == 1) return Math.max(grid[n-1][0], grid[n-1][1]);
        if (dp[n] != -1) return dp[n];
        dp[n] = Math.max(grid[n - 1][0], grid[n - 1][1]) + memoization(n - 2, grid, dp);
        return dp[n];
    }
}
