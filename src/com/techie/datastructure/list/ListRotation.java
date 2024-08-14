package com.techie.datastructure.list;

public class ListRotation {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int len = 1;
        ListNode curr = head;
        while (head.next != null) {
            len++;
            curr = head.next;
        }

        curr.next = head;
        k = k % len;
        k = len - k;

        while (k-- > 0) {
            curr = curr.next;
        }

        head = curr.next;
        curr.next = null;

        return head;
    }

    // Definition for singly-linked list.
    public class ListNode {
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
}
