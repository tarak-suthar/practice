package com.tarak.dsa.dynamicProgramming.intro;


import java.util.Arrays;

/*
 * Dynamic Programming
 *
 *

 */
public class Basics {
    public static void run() {

    }


    /*
    Prefix Sum Calculation

    solving a problem using sub-problems

    requires calculating repetitive sub problems

     */
    public int[] findPrefixSum(int[] A) {
        int[] pf = new int[A.length];

        // maintaining an array to store values for already calculated sub problem
        pf[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            pf[i] = pf[i - 1] + A[i];
        }

        return pf;
    }

    /*
    fibonacci using recursion
     */
    public int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /*
    here fibonacci meets both the requirements to use Dynamic Programming
    which is,
    It has Optimal Substructure
    It has Overlapping Sub-problems

    Use DP to memoize the answers to the sub problems to reduce time
     */
    public int fibonacciUsingDynamicProgramming(int n) {
        // we can use both tabulation and memoization
        // lets see memoization to see how to utilize it with recursion

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return fibonacci(n, dp);
    }


    // using overloading
    public int fibonacci(int n, int[] dp) {
        if (dp[n] != -1) return dp[n];
        if (n <= 1) {
            dp[n] = n;
            return n;
        }
        dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
        return dp[n];
    }
}
