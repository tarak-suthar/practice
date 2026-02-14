package com.tarak.dsa.a_intermediate.b_bitmanipulation;

import com.tarak.util.Result;

public class C_XSetBitsAndYUnsetBits {
    public static void main(String[] args) {
        int x = 6;
        int y = 3;
        int x1 = 1;
        int y1 = 2;
        C_XSetBitsAndYUnsetBits obj = new C_XSetBitsAndYUnsetBits();
        Result.printBinary(obj.setAndUnsetBits(x, y));
        Result.printBinary(obj.setAndUnsetBits(x1, y1));
    }

    private int setAndUnsetBits(int x, int y) {
        // using 2^(x+1) - 1 gives x set bits // learned while check Power of Two
        // left shit to move x set bits by y to add y zeros
        return ((1 << x) - 1) << y;
    }

}
