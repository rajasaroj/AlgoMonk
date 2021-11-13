package algomonk.geekforgeek;

public class ReverseLinkListBackTrackRecursive {

    /**
     *
     * [1|000A] [1|00B] [1|000C] [1|000D] [1|null]
     *
     * null
     *      [1|000A] (Address:0000) cacheValue = null, take current address 0000, goes in                         [Backtrack sets curr.next as cache value]
     *              [1|00B] (Address:000A) cacheValue = 0000, take current address 000A, goes in                  [Backtrack sets curr.next as cache value]
     *                      [1|000C] (Address:000B) cacheValue = 000A, take current address 000B, goes in         [Backtrack sets curr.next as cache value]
     *                              [1|000D] (Address:000C) cacheValue = 000B, take current address 000C, goes in [Backtrack sets curr.next as cache value]
     *                                      [1|null] (Address:000D) cacheValue = 000C, take current address 000D, [Hits null sets curr.next as cache value]
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        display(createLinkList());
        System.out.println("backTrack reversing link list");
        display(reverse(createLinkList()));
    }

    public static Node reverse(Node head) {
        return backTrackReverse(head, null);
    }










    public static Node backTrackReverse(Node curr, Node cache) {

        Node theLastNode;
        if (curr.next != null) theLastNode = backTrackReverse(curr.next, curr);
        else {
            curr.next = cache; return curr;
        }
        curr.next = cache;
        return theLastNode;
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


