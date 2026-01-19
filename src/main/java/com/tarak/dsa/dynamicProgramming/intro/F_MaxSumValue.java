package com.tarak.dsa.dynamicProgramming.intro;

public class F_MaxSumValue {
    /**
     * You are given an array A of N integers and three integers B, C, and D.
     *
     * You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.
     *
     * Constraints:
     * 1 <= N <= 105
     * -10000 <= A[i], B, C, D <= 10000
     *
     *  A = [1, 5, -3, 4, -2]
     *  B = 2
     *  C = 1
     *  D = -1
     *
     *  OP: 18
     */
    public static void main(String[] args) {

        /**
         * brute: start from k=2 to N for each k find the max sum j and i => TC: n^3
         *
         * can use recursion simply choosing 3 from n
         */

        /**
         *  choose, not choose
         *
         *  f(n, count)
         *  -> f(5, 3)
         *   ->  Max of ( f(5, 2) + A[5] * multiplier[2] or f(4, 3) )
         *   -> f(5, 2) -> Max of ( f(5, 1) + A[5] * multiplier[1] or f(4, 2) )
         *   -> f(4, 3) -> Max of ( f(4,2) + A[4] * multiplier[1] or f(3, 3) )
         */


        /**
         *
         */
    }


}
