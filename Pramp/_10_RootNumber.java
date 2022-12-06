package com.mert.Pramp;

public class _10_RootNumber {
    

    public static void main(String[] args) {
        System.out.println("expected: 1.91 | returned: " + String.format("%.2f", getRoot(7, 3)));// 1.91
        System.out.println("expected: 3.00 | returned: " + String.format("%.3f", getRoot(9, 2)));// 3.00
    }

    // x^1/n
    public static double getRoot(int x, int n) {
        double ans = 0.0;
        double l = 0, r = x;
        while(l < r) {
            double midVal = (l + r) / 2;
            double powMid = getPow(midVal, n);
            if(powMid <= x + 0.001 && powMid >= x-0.001) {
                ans = midVal;
                break;
            }

            if(powMid < x)
                l = midVal;
            else
                r = midVal;
        }

        return ans;
    }

    public static double getPow(double val, int pow) {
        double ans = 1;
        for(int i = 0; i < pow; i++){
            ans = ans * val;
        }
        return ans;
    }

}

/*
 Root of Number
In this question we’ll implement a function root that calculates the n’th root of a number.
 The function takes a nonnegative number x and a positive integer n, and returns the positive 
 n’th root of x within an error of 0.001 (i.e. suppose the real root is y, then the 
 error is: |y-root(x,n)| and must satisfy |y-root(x,n)| < 0.001).

Examples:

input:  x = 7, n = 3
output: 1.913

input:  x = 9, n = 2
output: 3

 */