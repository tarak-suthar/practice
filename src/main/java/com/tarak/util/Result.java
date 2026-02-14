package com.tarak.util;

import java.util.Arrays;
import java.util.List;

public class Result {
    private Result() {
    }

    public static void print(int n) {
        System.out.print(" result:" + n);
    }

    public static void print(int[] a) {
        System.out.println(" result: " + Arrays.toString(a));
    }

    public static void print(int[][] a) {

    }

    public static void print(int[][][] a) {

    }

    public static void print(List<List<Integer>> arr) {
        for (List<Integer> a : arr) {
            System.out.println(a);
        }
        System.out.println("==================");
    }

    public static void print(boolean a) {
        System.out.println("result: " + a);
    }

    public static void printBinary(int decimal) {
        StringBuilder sb = new StringBuilder();
        while (decimal > 0) {
            if ((decimal & 1) == 1) sb.append(1);
            else sb.append(0);
            decimal = decimal >> 1;
        }
        System.out.println("Result: " + sb.reverse());
    }

}
