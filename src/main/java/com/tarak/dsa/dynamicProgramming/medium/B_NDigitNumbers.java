package com.tarak.dsa.dynamicProgramming.medium;

import com.tarak.dsa.dynamicProgramming.Dp;
import com.tarak.util.Result;

public class B_NDigitNumbers {
    /*
    Find out the number of A digit positive numbers, whose digits on being added equals to a given number B.

    Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.

    Since the answer can be large, output answer modulo 1000000007
     */
    public static void main(String[] args) {
        new B_NDigitNumbers().solution(2, 4);
    }


    /*
    a = 2, b = 4
    1 3
    2 2
    3 1
    4 0

    a = 3, b = 12
    1 1 9 = 11 != 12
    1 2 9 = 12
    1 3 8 = 12
    1 4 7
    1 5 6
    1 6 5
    1 7 4
    1 8 3
    1 9 2

    now count way to get 11 using 2 digits

    1 9 X not possible
    2 9
    3 8
    4 7
    5 6
    6 5
    7 4
    8 3
    9 2 = ways = 8


    if choose 1 as fist number
    the 1 + ways to get remaining 11

     */

    /*
    f(12)(3) -> f(1)(1) + f(11)(2) | f(2)(1) + f(10)(2)

    f(4)(2) -> f(1)(1) + f(3)(1) | f(2)(1) + f(2)(1) | f(3)(1) + f(1)(1) | f(4)(1) + f(0)(1)
     */
    public void solution(int a, int b) {
        Result.print(countNDigitNumbers(a, b, Dp.TABULATION));
    }

    public int countNDigitNumbers(int a, int b, Dp type) {
        int[] count = new int[]{0};
        /*
        how to implement DP here
        dp of [choice of number][

         */
        findCount(0, 0, a, b, count);
        return count[0];
    }

    public void findCount(int n, int curr, int a, int b, int[] count) {
        if (n == b) {
            if (curr == a) {
                count[0]++;
            }
            return;
        }

        for (int i = 0; i < b; i++) {
            if (n == 0 && i == 0) continue;
            int x = curr + i;
            findCount(n + 1, x, a, b, count);
        }
    }

}
