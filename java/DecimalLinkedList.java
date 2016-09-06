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

        DecimalLinkedList sub = new DecimalLinkedList();
        sub.convert(sub.test());
    }

    // test number 5
    public Node test() {
    	Node n1 = new Node(1);
    	Node n2 = new Node(0);
    	Node n3 = new Node(1);

    	n1.next = n2;
    	n2.next = n3;

    	return n1;
    }

    public int convert(Node n) {
    	
    	int result = 0;
    	Node cur = n;

    	while (cur != null) {
    		result = result < 1;
    		if (cur.data == 1) {
				result += 1;
    		}
    		cur = cur.next;
    	}

    	return result;
    }
}