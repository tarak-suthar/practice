package com.tarak.dsa.a_intermediate.a_arrays;

import com.tarak.util.Result;

public class C_EquilibriumIndex {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 2, 7, 6};
        new C_EquilibriumIndex().solve(arr);
    }

    private void solve(int[] arr) {
        int idx = findEquilibriumIndex(arr);
        Result.print(idx);
    }

    private int findEquilibriumIndex(int[] arr) {
        int idx = -1;
        int[] ps = new int[arr.length];
        ps[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ps[i] = ps[i - 1] + arr[i];
        }

        if (arr[0] == (ps[arr.length - 1] - ps[0])) return 0;
        if (ps[arr.length - 2] == arr[arr.length - 1]) return arr.length - 1;
        for (int i = 1; i < arr.length - 1; i++) {
            int left = ps[i - 1];
            int right = ps[arr.length - 1] - ps[i];
            if (left == right) return i;
        }
        return idx;
    }

}
