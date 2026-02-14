package com.tarak.dsa.a_intermediate.b_bitmanipulation;

import com.tarak.util.Result;

public class A_SingleNumberIII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4, 5, 5};
        A_SingleNumberIII obj = new A_SingleNumberIII();
        Result.print(obj.getTwoUniqueNumbers(arr));
    }

    public int[] getTwoUniqueNumbers(int[] arr) {
        int xor = 0;
        for (int a : arr) {
            xor ^= a;
        }

        int index = getFirstSetIndex(xor);
        int x = 1 << index;

        int xor1 = 0;
        int xor2 = 0;
        for (int a : arr) {
            if ((a & x) == 1) {
                xor1 ^= a;
            } else {
                xor2 ^= a;
            }
        }

        if (xor1 < xor2) return new int[]{xor1, xor2};
        return new int[]{xor2, xor1};
    }

    private int getFirstSetIndex(int n) {
        int i = 0;
        if (n <= 0) return -1;
        while (n > 0) {
            if ((n & 1) == 1) return i;
            n = n >> 1;
            i++;
        }
        return i;
    }
}
