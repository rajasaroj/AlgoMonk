package algomonk.geekforgeek;

// 139 Write a Program to reverse the Linked List. (Both Iterative and recursive)
public class ReverseLinkListIterative {
    public static void main(String[] args) {
        display(createLinkList());
        System.out.println("reversing");
        display(reverseList(createLinkList()));
    }


    public static Node reverseList(Node head) {
        // code here
        Node  prev = null, curr, next;
        curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;

            if (next == null) {
                head = curr;
                break;
            }
            curr = next;
        }
        return head;
    }

    public static Node createLinkList () {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        return node;
    }

    public static void display(Node node) {
        Node cur = node;

        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.next;
        }
    }

}

class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
}
