package algomonk.linklist;


/*
 *  H                             T
 * [1|0001]->[2|0002]->[3|0003]->[4|null] -> null
 *   0000                          0003
 */
public class MiddleElement {

    Node head=null, tail=null;

    public Node add(int a) {

        Node n = new Node(a);

        if (head == null && tail == null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
        return n;
    }

    public void display() {
        Node curr = head;
        Node fast = head;

        while (curr != null) {

            if (fast == null || fast.next == null) {
                System.out.println(curr.data);
                break;
            }

            curr = curr.next;
            fast = fast.next.next;

        }
    }

    public static void main(String[] args) {
        MiddleElement m = new MiddleElement();
        m.add(1);
        m.add(2);
        m.add(3);
        m.add(4);
        m.add(5);
        //m.add(6);

        m.display();

    }


}

// Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
