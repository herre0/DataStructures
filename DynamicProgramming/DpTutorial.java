package com.mert.DynamicProgramming;

public class DpTutorial {

    // Top-Down
    static int fibonacci(int[] memoize, int n) {
        if (n < 2)
            return n;

        if (memoize[n] != 0)
            return memoize[n];

        memoize[n] = fibonacci(memoize, n - 1) + fibonacci(memoize, n - 2);
        return memoize[n];
    }

    // Bottom-Up
    static int fibonacci(int n) {
        if (n == 0)
            return 0;

        int memoize[] = new int[n + 1];
        memoize[0] = 0;
        memoize[1] = 1;

        for(int i = 2; i <= n; i++) 
            memoize[i] = memoize[i - 1] + memoize[i - 2];

        return memoize[n];
    }

    public static void main(String[] args) {

        int n = 10;
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        System.out.println("Top-Down Fibonacci: " + fibonacci(memo, n));
        System.out.println("Bottom-Up Fibonacci: " + fibonacci(n));

    }

    


}
