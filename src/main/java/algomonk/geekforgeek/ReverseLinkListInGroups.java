package algomonk.geekforgeek;

import java.util.stream.Stream;

/**
 * 140 Reverse a Linked List in group of Given Size. [Very Imp]
 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
 *
 */
public class ReverseLinkListInGroups {



    public static void main(String[] args) {
        Node root = new Node(1);
        //Stream.of(2,2,4,5,6,7,8).forEach(x -> add(root, x));
        //Stream.of(2,3,4,5).forEach(x -> add(root, x));
        Stream.of(2,3,4).forEach(x -> add(root, x));
        display(reverseHelper(root, 3));
    }



    public static Node reverse(Node node, int k) {
        return null;
    }

    /**
     *
     * basic reverse working
     * p      c       n
     * [null] [a|10] [b|20] [c|null]
     *
     * p         c       n
     * [a|null] [b|20] [c|null]
     *
     *          p       c       n
     * [a|null] [b|00] [c|null] null
     *
     *                  p     c
     * [a|null] [b|00] [c|10] null
     *
     *
     *
     *
     * ALGORITHM
     * Testcase:1
     * h=head
     * l=last
     *
     * p    hc       n
     * null [a|10] [b|20] [c|30] [d|40] [e|null]
     *       00      10     20     30     40
     *
     * k=2
     * c=1
     * c<=k true
     *       hp        c      n
     * null [a|null]  [b|20] [c|30] [d|40] [e|null]
     *       00       10     20     30     40
     * c++
     *
     *
     * Next loop
     * k=2
     * c=2
     * c<=k true
     *        h        p       c      n
     * null [a|null]  [b|00] [c|30] [d|40] [e|null]
     *       00       10     20     30     40
     * c++
     *
     *
     *
     * Next loop
     * k=2
     * c=3
     * c<=k false and if next!=null
     *      reset counter=1
     *      if last !=null
     *          last.next = previous
     *          last=head2
     *          set previous = null
     *          head2=current
     *
     *      else if head==null
     *          set last as head
     *          set head as previous
     *          set head2=current
     *          set previous = null
     *
     *  else if (next==null)
     *      last.next = current
     *
     *
     *
     *        last     hp     h2 c      n
     * null [a|null]  [b|00] [c|30] [d|40] [e|null]
     *       00       10     20     30     40
     *
     * so now the link list looks like this:
     *        hp      last    h2 c    n
     * null [b|00]  [a|null] [c|30] [d|40] [e|null]
     *       10       00     20     30     40
     *
     *
     *        h       last    h2 c    n
     * null [b|00]  [a|null] [c|30] [d|40] [e|null]
     *       10       00     20     30     40
     *
     *
     *
     * perform iteration again
     * new initial state
     *    h       last    p       h2 c     n
     *  [b|00]  [a|null]  null   [c|30] [d|40] [e|null]
     *   10       00              20       30     40
     *
     * Next loop
     * k=2
     * c=1
     *
     *    h       last            h2 p       c      n
     *  [b|00]  [a|null]  null   [c|null] [d|40] [e|null]
     *   10       00              20       30     40
     * c++;
     *
     * Next loop
     * k=2
     * c=2
     *
     *    h       last        h2       p      c        n
     *  [b|00]  [a|null]   [c|null] [d|20] [e|null]   null
     *   10       00        20       30     40
     *
     * c<=k false and if next!=null
     *      reset counter=1
     *      if last !=null
     *          last.next = previous
     *          last=head2
     *          set previous = null
     *          head2=current
     *
     *      else if head==null
     *          set last as head
     *          set head as previous
     *          set head2=current
     *          set previous = null
     *
     * else if (next==null)
     *      last.next = current
     *
     *
     *    h       last         h2      p      c        n
     *  [b|00]  [a|null]   [c|null] [d|20] [e|null]   null
     *   10       00        20     ¸  40
     *
     *   so new state of linklist will be
     *
     *   h                       last     p     h2 c     n
     * [b|00]  [a|40]  [d|20]   [c|null] null [e|null]  null
     *  10       00      40       20            50
     *
     *
     * Next loop
     * k=2
     * c=1
     *
     *   h                       last          h2 p c     n
     * [b|00]  [a|40]  [d|20]   [c|null] null [e|null]  null
     *  10       00      40       20            50
     *
     * n=null break out
     *   h                       last          h2 p c     n
     * [b|00]  [a|40]  [d|20]   [c|50]        [e|null]  null
     *  10       00      40       20            50
     *
     *
     *
     * what if we have one more node
     *
     * c=1
     *    h                       last          h2 p       c      n
     *  [b|00]  [a|40]  [d|20]   [c|null] null [e|null]   [f|null] null
     *   10       00      40       20            50        60
     *
     * c=2
     *    h                       last          h2 p        c      n
     *  [b|00]  [a|40]  [d|20]   [c|null] null [e|null]   [f|50] null
     *   10       00      40       20            50        60
     *
     *
     *
     *
     *
     *
     */
    public static Node reverseHelper(Node node, int k) {
        Node pervious = null;
        Node current = node;
        Node fnext = current.next;
        int counter=1;
        Node head = null;
        Node head2= null;
        Node last = null;

        if (node.next == null) return node;

        while (true) {
            if (counter <=k) {
                current.next = pervious;
                if (fnext != null) {
                    pervious = current;
                    current = fnext;
                    fnext = fnext.next;
                } else {

                    // If the length of link list <= k this code will avoid the null pointer exception by directly setting head at end of link list that is current
                    if (last != null) {
                        last.next = current;
                        break;
                    } else {
                        head = current;
                        break;
                    }
                }
                counter++;

            } else if (counter > k || fnext != null) {
                counter=1;

                if (last != null) {
                    last.next = pervious;
                    last = head2;
                    pervious=null;
                    head2=current;

                } else if (head == null) {
                    last = node;
                    head = pervious;
                    head2=current;
                    pervious=null;
                }
            }
        }
        return head;
    }








    public static void add(Node root, int data) {
        Node curr = root;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(data);
    }

    public static void display(Node root) {
        Node curr = root;
        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }

}