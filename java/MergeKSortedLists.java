package com.foxley.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


/*
    Merge K Sorted Lists
    draft
 */

public class MergeKSortedLists {


    public static void main(String[] args) {
        ArrayList<int[]> list = new ArrayList<>();

        list.add(new int[] { 1, 5, 8, 9 });
        list.add(new int[] { 2, 3, 7, 10 });
        list.add(new int[] { 4, 6, 11, 15 });
        list.add(new int[] { 9, 14, 16, 19 });
        list.add(new int[] { 2, 4, 6, 9 });

        final ArrayList<Integer> results = merge(list);
        print(results);
    }

    public static ArrayList<Integer> merge(ArrayList<int[]> arr) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return n1 - n2;
            }
        });

        for (int i = 0; i < arr.size(); i++) {
            for (int[] a : arr) {
                if (i < a.length) {
                    pq.add(a[i]);
                }
            }
        }

        ArrayList<Integer> results = new ArrayList<>();
        while (!pq.isEmpty()) {
            results.add(pq.poll());
        }

        return results;
    }

    public static void print(ArrayList<Integer> list) {
        for (Integer a : list) {
            System.out.println(a);
        }
    }
}
