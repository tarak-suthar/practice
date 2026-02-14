package com.tarak.dsa.a_intermediate.a_arrays;

import com.tarak.util.Result;

public class B_PrefixSum {
    public static void main(String[] args) {
        int[] arr = {1, -3, 4, 6, 11, 5, 8, -1, 13};
        int[][] queries = {
                {0, 1},
                {0, 5},
                {2, 6},
                {1, 3},
                {5, 8}
        };

        new B_PrefixSum().solve(arr, queries);
    }

    private void solve(int[] arr, int[][] queries) {
        int[] res = sumQueries(arr, queries);
        Result.print(res);
    }

    private int[] sumQueries(int[] arr, int[][] queries) {
        int[] ps = new int[arr.length];
        int[] result = new int[queries.length];
        ps[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ps[i] = ps[i - 1] + arr[i];
        }

        int i = 0;
        for (int[] q : queries) {
            int start = q[0];
            int end = q[1];

            // ps = 1, -2, 2, 8, 19, 24, 32, 31, 44
            if (start == 0) result[i] = ps[end];
            else result[i] = ps[end] - ps[start - 1];
            i++;
        }

        return result;
    }

}
