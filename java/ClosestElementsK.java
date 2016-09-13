package com.foxley.interview;

import java.util.Random;

/**
 *
 *  Date 09/12/2016
 *  @author Jecho Ricafrente
 *
 *  In a sorted array, find closets kth elements to a given value
 *
 *  return Integer.MIN_VALUE if given value does not exist, if given value
 *  does then print values
 *
 *
 *  ASSUMPTIONS:
 *      array is sorted, array is distinct, and number's can be neg and pos
 *
 *      Time complexity is log n where n is the array's length, where closets
 *      k elements is k time
 *      Space complexity is O(1)
 *
 *  VARIANTS:
 *      if the array is not sorted, sort it
 *      anything that involves looking around a pivot
 *
 */
public class ClosestElementsK {

    public static void main(String args[]) {
        ClosestElementsK obs = new ClosestElementsK();
        int[] tmp = obs.mockUp();
        // search for 6
        int index = obs.binarySearch(6,tmp);
        // iterate to 3 cells (left and right)
        obs.closets(index, tmp, 3);
    }

    public void closets(int index, int[] arr, int count) {
        if (index == Integer.MIN_VALUE) return;
        int l = index;
        int r = index;
        int iter = 0;
        while (iter < count) {
            l -= 1;
            r += 1;
            if (l > 0) {
                System.out.println(arr[l]);
            }
            if (r < arr.length) {
                System.out.println(arr[r]);
            }
            iter++;
        }
    }

    // return index
    public int binarySearch(int n, int[] arr) {

        int low = 0;
        int high = arr.length-1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > n) {
                high = mid - 1;
            } else if (arr[mid] < n) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }

        return Integer.MIN_VALUE;
    }

    public int[] mockUp() {
        Random rand = new Random();
        int[] a = new int[10];
        int count = 0;
        for (int i = 0 ; i < a.length; i++) {
            count += 2;
            a[i] = count;
        }
        return a;
    }

//    public int[] mockUp() {
//        Random rand = new Random();
//        int[] a = new int[10];
//        for (int i = 0 ; i < a.length; i++) {
//            int randomNum = rand.nextInt((20 - 0) + 1) + 0;
//            a[i] = randomNum;
//        }
//        return a;
//    }
}
