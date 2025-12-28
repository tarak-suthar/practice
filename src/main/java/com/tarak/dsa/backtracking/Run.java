package com.tarak.dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        problem2();
    }

    public static void problem1() {
        // list all the subsets from a list of integers
        // subset should be sorted in ascending order
        // input list is not sorted

        List<Integer> input = List.of(1, 2, 3);
        List<List<Integer>> res = Subsets.solve(input);
        res.sort((l2,l1)->{
            int minLen = Math.min(l1.size(),l2.size());
            boolean positive = true;
            for(int i = 0 ; i<minLen; i++){
                if((l2.get(i) - l1.get(i))<0) positive = false;
            }
            if(positive) return 1;
            else return -1;
        });
        System.out.println(res);
    }

    public static void problem2(){
        ArrayList<Integer> input = new ArrayList<>(List.of(1, 2, 3));
        System.out.println(Permutations.solve(input));
    }
}
