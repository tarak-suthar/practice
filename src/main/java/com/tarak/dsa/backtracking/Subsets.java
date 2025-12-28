package com.tarak.dsa.backtracking;


import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> solve(List<Integer> A) {
        // (pos, A, currentAns, result)
        List<List<Integer>> result = new ArrayList<>();
        solve(0, A, new ArrayList<>(), result);
        return result;
    }

    public static void solve(int pos, List<Integer> A, List<Integer> list, List<List<Integer>> res) {
        if (pos == A.size()) {
            StringBuilder sb = new StringBuilder();
            list.sort((a, b) -> a - b);
            res.add(new ArrayList<>(list));
            return;
        }
        solve(pos + 1, A, list, res);
        list.add(A.get(pos));
        solve(pos + 1, A, list, res);
        list.remove(list.size() - 1);
    }
}
