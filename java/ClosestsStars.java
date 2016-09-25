package com.foxley.interview;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 *  Date 09/13/2016
 *  @author Jecho Ricafrente
 *
 *	Say you have an very large amount of stars (say a billion) and you need to find
 *	the closets stars to Earth? keep track of the 100th closest
 *
 *  ASSUMPTIONS:
 *		you are given the calculated distance already
 *      - limited space, could put all elements in an array and sort "if" space were
 *		not an issue
 *		- binary heap / priority queue makes sense, we could add the starts that are
 *		currently closests and when the pq reaches its peak we could remove the trailing
 *		stars to compensate
 *
 *	Time complexity insert 
 *		- insert O(log n)
 *		- find O(1)
 *
 *  Possible improvements
 *      - use lambda
 *
 *  Varients
 *      - when limited memory is a requirement, and you need to maintain a set of k values,
 *      probably use a min/max heap
 *
 *	Space complexity O(n) when n is the amount of stars that will be stored
 */


public class ClosestsStars {

    public class Star {

        String name;
        int distance;

        public Star(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }
    }

    public static void main(String args[]) {
        ClosestsStars obj = new ClosestsStars();
        obj.print(obj.closests(obj.mockup()));
    }

    public PriorityQueue<Star> closests(Star[] s) {
        PriorityQueue<Star> pq = new PriorityQueue<>(new Comparator<Star>() {
            @Override
            public int compare(Star n1, Star n2) {
                return n2.distance - n1.distance;
            }
        });

        int limit = 5;
        for (int i = 0; i < limit; i++) {
            pq.add(s[i]);
        }

        while (limit < s.length) {
            if (s[limit].distance <= pq.peek().distance) {
                pq.remove();
                pq.add(s[limit]);
            }
            limit++;
        }

        return pq;
    }

    public void print(PriorityQueue<Star> pq) {
        while (!pq.isEmpty()) {
            System.out.println(pq.poll().distance);
        }
    }

    public Star[] mockup() {
        Star[] s = new Star[] {
                new Star ("a1", 5), new Star ("a2", 2),new Star ("a3", 12),new Star ("a4", 0),
                new Star ("a5", 3), new Star ("a6", 11), new Star ("a7", 33), new Star ("a8", 22),
                new Star ("a9", 1), new Star ("a10", 9), new Star ("a11", 5)};
        return s;
    }
}
