package com.techie.datastructure.list;

public class ReordeList {
    ListNode head;
    ListNode tail;

    public ReordeList() {
        this.head = null;
        this.tail = null;
    }

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

    }

    private int size(ListNode head){
        int size = 0;
        while (head != null){
            size++;
            head = head.next;
        }
        return size;
    }

    public void add(int data){
        ListNode node = new ListNode(data);
        if (head == null){
            head = node;
        }
        else {
            tail.next = node;
        }
        tail = node;
    }

    public void reorderList(ListNode head){
        ListNode listNode = reorderList(head, size(head));
        System.out.println(listNode);
    }

    private ListNode reorderList(ListNode head, int size){
        if (size == 0)
            return null;
        if (size == 1)
            return head;
        if (size == 2)
            return head.next;

        ListNode tail = reorderList(head, size - 2);
        //swap
        ListNode temp = tail.next;
        tail.next = tail.next.next;
        temp.next = head.next;
        head.next = temp;

        return tail;
    }

    public static void main(String[] arg){
        ReordeList reordeList = new ReordeList();
        reordeList.add(1);
        reordeList.add(2);
        reordeList.add(3);
        reordeList.add(4);
    }

}
