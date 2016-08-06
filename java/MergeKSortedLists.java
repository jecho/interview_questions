package com.foxley.interview;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


/*
    Merge K Sorted Lists
    Approach is to use a Heap/PriorityQueue (pq);
    Since we know the arrays are sorted, we first add the first element in each array, and then poll
    and add the result to the set, afterwards we add the next element into the pq from the array we have pulled
    from until, doing this approach until pq is exhausted;
    A node class is created to hold the the value, array index it came from, and the current place the value represents
 */

public class MergeKSortedLists {


    public static class Node {
        public int index;
        public int data;
        public int place;

        public Node(int data, int index, int place) {
            this.data = data;
            this.index = index;
            this.place = place;
        }
    }

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

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.data - n2.data;
            }
        });

        for (int i = 0; i < arr.size(); i++) {
            pq.add(new Node(arr.get(i)[0], i, 0));
        }

        ArrayList<Integer> results = new ArrayList<>();
        while(!pq.isEmpty()) {
            Node tmp = pq.poll();
            results.add(tmp.data);
            ++tmp.place;
            if (tmp.place < arr.get(tmp.index).length) {
                pq.add(new Node(arr.get(tmp.index)[tmp.place], tmp.index, tmp.place));
            }
        }

        return results;
    }

    public static void print(ArrayList<Integer> list) {
        for (Integer a : list) {
            System.out.println(a);
        }
    }
}
