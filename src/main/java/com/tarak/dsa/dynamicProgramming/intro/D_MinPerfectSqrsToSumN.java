package com.tarak.dsa.dynamicProgramming.intro;

import com.tarak.dsa.dynamicProgramming.Dp;
import com.tarak.util.Result;

import java.util.Arrays;

public class D_MinPerfectSqrsToSumN {

    public static void main(String[] args) {
        int n = 12;
        new D_MinPerfectSqrsToSumN().solution(n);
    }


    public void solution(int n) {
        Result.print(findMinimumPerfectSquaresRequired(n, Dp.MEMOIZATION));
        Result.print(findMinimumPerfectSquaresRequired(n, Dp.TABULATION));
    }

    /*
    Given N return the minimum perfect squares required to make Sum N
     */
    public int findMinimumPerfectSquaresRequired(int n, Dp type) {
        /*
         12 -> perfect squares in 12 are 1, 2, 3
         12 -> choose one way +
                        12
             1*1, 11                      ||   2*2, 8               ||   3*3, 3
             1*1, 10 |  2*2, 7 | 3*3, 3   ||    1*1, 7 | 2*2, 4     ||  1*1, 2

         */

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        if (type.equals(Dp.MEMOIZATION)) return memoization(n, dp);
        else return tabulation(n);
    }

    private int memoization(int n, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int x = i * i;
            min = Math.min(min, memoization(n - x, dp));
        }
        dp[n] = 1 + min;
        return dp[n];
    }

    private int tabulation(int n) {
        return 0;
    }
}