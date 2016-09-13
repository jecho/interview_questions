package com.foxley.interview;

/**
 *
 *  Date 09/13/2016
 *  @author Jecho Ricafrente
 *
 *  ASSUMPTIONS:
 *      array is not sorted
 *		elements are not distinct
 *		elements can be both positive and negative numbers
 *		if the largest element is 0, than that is the largest subarray
 *
 *      Time complexity is n time where n is the length of the array
 *      Space complexity is O(1)
 *
 */

public class LargestContiguousSubarray {

    public static void main(String args[]) {

        // test case
        // looking for 7, range is from 4, -1, -2, 1, 5
        int[] a = new int[]  {-2, -3, 4, -1, -2, 1, 5, -3};

        int n = 0;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            int c = n + a[i];
            if (c >= 0) {
                n = c;
                if (c > max) {
                    max = c;
                }
            } else {
                n = 0;
            }
        }

        System.out.println(max);
    }
}