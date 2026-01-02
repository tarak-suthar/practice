package com.tarak.dsa.dynamicProgramming.intro;

import java.util.Arrays;

public class C_NStairs {
    public static void solve() {

    }

    public void solution(int n) {
        /*
        it takes n steps to reach the top
        given two ways to jump 1 or 2 steps
        need to find ways to reach the top
         */

        /*
        fun(n)
        can be reached from n-1 and n-2
        that is ways to reach fun(n-1) + fun(n-2)

        fun(3)

        f(2) + f(1) = 2 + 1 = 3
         */

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        int ans1 = memoization(n, dp);

        int ans2 = tabulation(n);

        System.out.println(" Tabulation:" + ans2 + ", Memoization:" + ans1);
    }

    public int tabulation(int n) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }


    public int memoization(int n, int[] dp) {
        if (n <= 2) return n;

        if (dp[n] == -1) {
            dp[n] = dp[n - 1] + dp[n - 2];
        }

        return dp[n];
    }


}
