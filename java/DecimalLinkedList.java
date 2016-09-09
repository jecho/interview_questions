package com.foxley.interview;

/**
 *
 *  Date 09/4/2016
 *  @author Jecho Ricafrente
 *
 *  Based on a linked list representation of a binary number (positive number ( 0 <= num )),
 *  return the decimal representation (base 10)
 *
 *  return -1 if linked list is null
 *
 *  ASSUMPTIONS:
 *      positive number, including zero. nothing fancy and not related to 1's/2's complement
 *
 *      Time complexity is O(n) where n is the length of the linked list
 *      Space complexity is O(1)
 *
 */

public class DecimalLinkedList {

    // our version of a linked list, denoted as a 'node'
    public class Node {
        public Node next;
        public int data;

        public Node(int num) {
            this.data = num;
        }
    }

    public static void main(String[] args) {

        DecimalLinkedList m = new DecimalLinkedList();
        // either use a system out, or use an assert, your flavour
        System.out.println(m.convert(null));
        System.out.println(m.convert(m.test0()));
        System.out.println(m.convert(m.test1()));
        System.out.println(m.convert(m.test2()));
        System.out.println(m.convert(m.test3()));
        System.out.println(m.convert(m.test4()));
        System.out.println(m.convert(m.test5()));
        System.out.println(m.convert(m.test6()));
        System.out.println(m.convert(m.test7()));
    }

    public int convert(Node n) {

        if (n == null) return -1;

        int result = 0;
        Node cur = n;

        while (cur != null) {
            result = result << 1;
            if (cur.data == 1) {
                result += 1;
            }
            cur = cur.next;
        }

        return result;
    }

    /*
        test cases listed below
     */


    // test number 0
    public Node test0() {
        Node n1 = new Node(0);
        Node n2 = new Node(0);
        Node n3 = new Node(0);

        n1.next = n2;
        n2.next = n3;

        return n1;
    }

    // test number 1
    public Node test1() {
        Node n1 = new Node(0);
        Node n2 = new Node(0);
        Node n3 = new Node(1);

        n1.next = n2;
        n2.next = n3;

        return n1;
    }

    // test number 2
    public Node test2() {
        Node n1 = new Node(0);
        Node n2 = new Node(1);
        Node n3 = new Node(0);

        n1.next = n2;
        n2.next = n3;

        return n1;
    }

    // test number 3
    public Node test3() {
        Node n1 = new Node(0);
        Node n2 = new Node(1);
        Node n3 = new Node(1);

        n1.next = n2;
        n2.next = n3;

        return n1;
    }

    // test number 3
    public Node test4() {
        Node n1 = new Node(1);
        Node n2 = new Node(0);
        Node n3 = new Node(0);

        n1.next = n2;
        n2.next = n3;

        return n1;
    }

    // test number 5
    public Node test5() {
        Node n1 = new Node(1);
        Node n2 = new Node(0);
        Node n3 = new Node(1);

        n1.next = n2;
        n2.next = n3;

        return n1;
    }

    // test number 6
    public Node test6() {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(0);

        n1.next = n2;
        n2.next = n3;

        return n1;
    }

    // test number
    public Node test7() {
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(1);

        n1.next = n2;
        n2.next = n3;

        return n1;
    }
}