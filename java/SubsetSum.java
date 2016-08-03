package com.foxley.interview;

/*
 *
 *  Date 08/02/2016
 *  @author Jecho Ricafrente
 *
 *  Dynamic Programming — Subset Sum Problem
 *
 *  Given a set of pos­i­tive inte­gers, and a value sum S, find out if there exist a
 *  sub­set in array whose sum is equal to given sum S.
 *  
 *  time O(target * n) where n is array's length
 *
 */

import java.util.ArrayList;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 7, 12, 8, 10, 4};

        System.out.println(findSubsets(arr, 4));
        System.out.println(findSubsets(arr, 5));
        System.out.println(findSubsets(arr, 10));
        System.out.println(findSubsets(arr, 2));
        System.out.println(findSubsets(arr, 9));
    }

    public static ArrayList<Integer> findSubsets(int[] arr, int target) {

        // declare the matrix, where arr.length is your row and your
        // columns is your target value + 1
        boolean[][] tmp = new boolean[arr.length +  1 ][target + 1];

        // your values cannot be in the set, so let's set 0 as true
        for (int i = 0; i <= arr.length; i++) {
            tmp[i][0] =  true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                tmp[i][j] = tmp[i-1][j];

                if (tmp[i][j]==false && j>= arr[i-1]) {
                    tmp[i][j] = tmp[i][j] || tmp[i-1][j-arr[i-1]];
                }
            }
        }

        ArrayList<Integer> returnSet = new ArrayList<>();

        int x = arr.length;
        int y = target;
        while (y != 0) {
            if (y < 0) return new ArrayList<Integer>();
            if (tmp[x-1][y] == false) {
                returnSet.add(arr[x-1]);
                y = y - arr[x-1];
                x--;
            } else {
                x--;
            }
        }

        return returnSet;
    }

    public static boolean isExists(int[] arr, int target) {

        // declare the matrix, where arr.length is your row and your
        // columns is your target value + 1
        boolean[][] tmp = new boolean[arr.length +  1 ][target + 1];

        // your values cannot be in the set, so let's set 0 as true
        for (int i = 0; i <= arr.length; i++) {
            tmp[i][0] =  true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                tmp[i][j] = tmp[i-1][j];

                if (tmp[i][j]==false && j>= arr[i-1]) {
                    tmp[i][j] = tmp[i][j] || tmp[i-1][j-arr[i-1]];
                }
            }
        }

        return tmp[arr.length][target];
    }
}
