package com.foxley.interview;

/*
 *
 *  Date 05/09/2016
 *  @author Jecho Ricafrente
 *
 *  Reverse an Integer
 *
 *  Time complexity is O(n)
 *  Space complexity is O(1)
 *
 */

public class ReverseInteger {

    public static int reverseInt(int x) {

        boolean sign = false;
        if (x < 0) {
            sign = true;
            x *= -1;
        }

        int rev = 0;
        while (x > 0) {
            int mod = x % 10;
            rev = rev * 10 + mod;
            x /= 10;
        }

        if (sign) {
            rev *= -1;
        }

        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverseInt(-123) == -321);
        System.out.println(reverseInt(0) == 0);
        System.out.println(reverseInt(30) == 3);
        System.out.println(reverseInt(123) == 321);
    }
}
