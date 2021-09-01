package com.makotogu.algorithm.test;

public class TestFactorial {

    public static void main(String[] args) {
        long factorial = factorial(5);
        System.out.println(factorial);
    }

    public static long factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return factorial(n-1) * n;
    }
}
