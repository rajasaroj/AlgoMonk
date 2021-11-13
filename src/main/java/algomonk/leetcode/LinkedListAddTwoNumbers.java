package algomonk.leetcode;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class LinkedListAddTwoNumbers {

    public static void main(String[] args) {
        Stream.of(2, 4, 3);
        Stream.of(5, 6, 4);
        ListNode l1 = createStringToLinkList("1000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001");
        ListNode l2 = createStringToLinkList("564");
        ListNode st = new LinkedListAddTwoNumbers().addTwoNumbers(l1, l2);
        System.out.println(createLinkListToString(st));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        BigDecimal s1 = new BigDecimal(createLinkListToString(l1).reverse().toString());
        BigDecimal s2 = new BigDecimal(createLinkListToString(l2).reverse().toString());
        BigDecimal result = s1.add(s2);
        StringBuilder rev = new StringBuilder(result.toString());
        rev.reverse();
        return createStringToLinkList(rev.toString());
    }

    public static StringBuilder createLinkListToString(ListNode l) {
        StringBuilder sb = new StringBuilder();
        while (l != null) {
            sb.append(l.val);
            l = l.next;
        }
        return sb;
    }

    public static ListNode createStringToLinkList(String str) {
        ListNode lst = null;
        ListNode head = null;
        for (int i = 0; i < str.length(); i++) {

            if (lst == null) {
                lst = new ListNode(str.charAt(i) - 48);
                head = lst;
            }
            else {
                lst.next = new ListNode(str.charAt(i) - 48);
                lst = lst.next;
            }
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
