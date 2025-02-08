package com.springheaven.transformx.codility;

public class Gcd {

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int gcd = gcd(3,2);
        System.out.println(2 % 1);
        System.out.println(gcd);
    }
}
