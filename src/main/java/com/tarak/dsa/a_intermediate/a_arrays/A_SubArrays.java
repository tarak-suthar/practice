package com.tarak.dsa.a_intermediate.a_arrays;

import com.tarak.util.Result;

import java.util.ArrayList;
import java.util.List;

public class A_SubArrays {
    /**
     * @param args
     */
    public static void main(String[] args) {
        /**
         *
         */
        int[] a1 = {-1, 2, 1, 11, 9, 5, 7, 8};
        int[] a2 = {8, -9, 11, -1, 5, 7, 4, -3};
        A_SubArrays object = new A_SubArrays();
        Result.print(object.subArrays(a1));
        Result.print(object.maxSubarraySum(a2));
    }

    public List<List<Integer>> subArrays(int[] arr) {
        List<List<Integer>> subarrays = new ArrayList<>();
        subarrays.add(List.of());
        for (int i = 0; i < arr.length; i++) {
            List<Integer> array = new ArrayList<>();
            for (int j = i; j < arr.length; j++) {
                array.add(arr[j]);
                subarrays.add(new ArrayList<>(array));
            }
        }
        return subarrays;
    }

    public int maxSubarraySum(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            sum += a;
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }

        return max;
    }


}
