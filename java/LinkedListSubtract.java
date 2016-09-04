package com.foxley.interview;

import java.util.ArrayList;

/*
 *  Date 09/03/2016
 *  @author Jecho Ricafrente
 *
 *  iterative version;
 *  handles non negative numbers, assumes first number is never less than the second,
 *  in place, O(1) time complexity 
 *
 *  notes: need to add more test cases
 *
 */
public class LinkedListSubtract {

    // our version of a linked list, denoted as a 'node'
    public class Node {
        public Node next;
        public int data;

        public Node(int num) {
            this.data = num;
        }
    }

    public static void main(String[] args) {

        LinkedListSubtract sub = new LinkedListSubtract();
        sub.subtract(sub.test());
    }

    // test method, tests 100-82
    public ArrayList<Node> test() {
        Node n1 = new Node(1);
        Node n2 = new Node(0);
        Node n3 = new Node(0);

        n1.next = n2;
        n2.next = n3;

        Node m1 = new Node(8);
        Node m2 = new Node(2);
        m1.next = m2;

        ArrayList<Node> arr = new ArrayList<>();
        arr.add(n1);
        arr.add(m1);

        return arr;
    }

    // method to determine the size of the linked list
    public int size(Node node) {
        int count = 0;
        Node cur = node;
        while (cur != null) {
            count += 1;
            cur = cur.next;
        }
        return count;
    }

    // append a zero to the front to keep the two linked list numbers
    // of equal size
    public Node addZero(Node node, int diff) {
        Node cur = node;
        int count = 0;
        while (count < diff) {
            Node n = new Node(0);
            n.next = cur;
            cur = n;
            count++;
        }

        return cur;
    }

    // main method that does the subtraction of the linked list
    public void subtract(ArrayList<Node> list) {
        Node n = list.get(0);
        Node m = list.get(1);

        // get the length
        int size = 0;
        int nSize = size(n);
        int mSize = size(m);

        size = mSize;
        if (mSize < nSize) {
            m = addZero(m, Math.abs(nSize - mSize));
            size = nSize;
        }

        int count = 0;
        boolean borrowed = false;
        Node prev = null;
        Node result = m;
        while (count < size) {
            int diff = 0;
            if (n.data < m.data) {
                diff = 10 + n.data - m.data;
                borrowed = true;
            } else {
                diff = n.data - m.data;
            }
            if (borrowed) {
                prev.data -= 1;
            }
            m.data = diff;
            prev = m;
            m = m.next;
            n = n.next;
            count++;
            borrowed = false;
        }
        
    }
}
