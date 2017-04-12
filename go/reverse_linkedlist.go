package main

import (
	"fmt"
)

type Node struct {
	data int
	next *Node
}

type List struct {
    head *Node
}

func (n *Node) Next() *Node {
    return n.next
}

func reverseList(h *Node) *Node {
	var newNode *Node = nil
	var cur *Node = h
	var prev *Node = nil
	for ; cur != nil; {
		newNode = cur.next
		cur.next = prev
		prev = cur
		cur = newNode
	}

	return prev
}

func print(h *Node) {
	c := h;
	for ; c != nil; c = c.Next() {
		fmt.Println(c.data)
	}
}

func main() {
	testCases()
}

func testCases() {
	a := Node{6,nil}
	b := Node{7,nil}
	c := Node{8,nil}
	d := Node{9,nil}
	a.next = &b
	b.next = &c
	c.next = &d
	var newList *Node = reverseList(&a)
	print(newList)
}
