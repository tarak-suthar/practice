package com.tarak.dsa.a_intermediate.b_bitmanipulation;

import com.tarak.util.Result;

public class B_IsPowerOfTwo {
    public static void main(String[] args) {
        int n = 79;
        int n1 = 64;
        int n2 = 1024;
        int n4 = 136;

        B_IsPowerOfTwo obj = new B_IsPowerOfTwo();
        Result.print(obj.isPowerOfTwo(n));
        Result.print(obj.isPowerOfTwo(n1));
        Result.print(obj.isPowerOfTwo(n2));
        Result.print(obj.isPowerOfTwo(n4));
    }

    private boolean isPowerOfTwo(int n) {
        // 8 & 7 = 0; // AND operation between n & n-1 is always 0 if n is power of 2
        return (n & (n - 1)) == 0;
    }

}
