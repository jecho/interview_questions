package com.foxley.interview;

/**
 *
 *  Date 08/20/2016
 *  @author Jecho Ricafrente
 *
 *  Find the first element greater than k (target)
 *
 *  Idea is to use a modified version of binary search, and keep track of the
 *  element larger than the target, same idea applies if searching for the next
 *  smallest element
 *
 *  ASSUMPTIONS:
 *      assumes array is sorted and that they are natural numbers (0,1,2,etc)
 *
 *      Time complexity is O(log n) avg
 *      Space complexity is O(1)
 */

public class FirstElementGreaterThanK {
    public static void main(String[] args) {
        int[] arr = new int[] { 1,2,3,4,4,5,6,7};
        System.out.println(optimized(arr,5));
    }

    public static int optimized(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        int result = - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                result = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;  // depends on your sentinal value and requirements
    }

    public static int brute(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > target) {
                return arr[i];
            } else if (arr[i] < target) {
                // ignore
            }
        }

        return -1;  // depends on your sentinal value and requirements
    }
}
