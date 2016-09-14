package com.foxley.interview;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 *  Date 09/14/2016
 *  @author Jecho Ricafrente
 *
 *  Calculate the median of real time data coming in at each input, we will impersonate and
 *  iterate an array as if each entry is a new live one coming in
 *
 *  Time complexity log n
 *  Space complexity n
 *
 */

public class RealTimeMedian {
    public static void main(String args[]) {

        int[] a = new int[] { 5, 7, 8, 2, 4};

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int iter = 0;
        while (iter < a.length) {
            int x = a[iter];
            if (minHeap.isEmpty()) {
                minHeap.add(x);
            } else {
                if (x >= minHeap.peek()) {
                    minHeap.add(x);
                } else {
                    maxHeap.add(x);
                }
            }

            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.remove());
            } else if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.remove());
            }

            System.out.print("Iteration " + iter + ": ");
            if (minHeap.size() == maxHeap.size()) {
                System.out.println((minHeap.peek() + maxHeap.peek()) * .5);
            } else {
                System.out.println(minHeap.peek());
            }
            iter++;
        }
    }
}
