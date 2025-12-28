package com.tarak.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> solve(List<Integer> A) {
        List<List<Integer>> result = new ArrayList<>();
        /*
           1, 2, 3

           123
           132
           213
           231
           312
           321

         */
        solve(0, A, new ArrayList<>(), result);
        return result;
    }

    public static void solve(int pos, List<Integer> A, ArrayList<Integer> currList, List<List<Integer>> result) {
        if (pos == A.size()) {
            result.add(new ArrayList<>(currList));
            return;
        }
        for (int i = pos; i < A.size(); i++) {
            currList.add(A.get(i));
            // swap positions
            swap(A, pos, i);
            solve(pos + 1, A, currList, result);
            // swap back positions
            swap(A, pos, i);
            currList.remove(currList.size() - 1);
        }
    }

    public static void swap(List<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
}
