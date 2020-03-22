package com.techie.datastructure.list;

public class RemoveDuplicate<T> {
    class Node {
        Node next;
        T data;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    Node head;
    Node tail;

    public void addNode(T data){
        Node node = new Node(data);

        if (head == null){
            //list is empty
            head = node;
        }
        else{
            //list is not empty
            tail.next = node;
        }
        tail = node;
    }

    public void removeDuplicate(){
        Node current = head, temp, index;

        if (current == null)
            return;

        while (current != null){
            temp = current;
            index = current.next;

            while (index != null){
                if (current.data == index.data){
                    temp.next = index.next;
                }
                else{
                    temp = index;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    public void printList(){
        StringBuilder sb = new StringBuilder();
        Node node = this.head;
        if (node == null)
            sb.append("Empty List");

        while (node != null){
            sb.append(node.data);
            if (node.next != null) sb.append(" -> ");
            node = node.next;
        }
        System.out.println(sb.toString());
    }


    public static void main(String[] args){
        RemoveDuplicate<Integer> list = new RemoveDuplicate<>();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(1);
        list.addNode(2);
        list.addNode(4);
        System.out.println("Original List");
        list.printList();
        System.out.println("Final List");
        list.removeDuplicate();
        list.printList();
    }
}
