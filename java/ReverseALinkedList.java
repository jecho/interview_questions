package com.foxley.interview;

/*
 *
 *  Date 05/10/2016
 *  @author Jecho Ricafrente
 *
 *  Reverse a Single Linked List
 *
 *  Time complexity is O(n)
 *  Space complexity is O(1)
 *
 */

public class ReverseALinkedList {

    // our implementation of LinkedListNode; 
    // could use java.util.LinkedList instead
    public class ListNode {
        ListNode next;
        ListNode prev;
        public ListNode() { }
    }

    public ListNode reverseList(ListNode head) {

        ListNode newNode = null;
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            newNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = newNode;
        }

        return prev;
    }
}
