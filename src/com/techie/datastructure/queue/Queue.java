package com.techie.datastructure.queue;

public class Queue<T>{

    class Node<T>{
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    Node front, back;
    int size;

    public Queue() {
        this.front = null;
        this.back = null;
        size = 0;
    }

    int getSize(){
        return this.size;
    }

    void enqueue(T item){
        Node<T> node = new Node(item);
        if (back != null)
            back.next = node;
        back = node;
        if (front == null)
            front = node;

        size++;
    }

    T dequeue(){
        if (front == null)
            throw new  IllegalStateException("Queue is empty");
        T data = (T)front.data;
        front = front.next;
        if (front == null)
            front = back;
        size--;
        return data;
    }

    T peek(){
        if (front == null)
            throw new IllegalStateException("Queue is empty");
        return (T)front.data;
    }

    void print(){
        Node currentNode = front;
        StringBuilder sb = new StringBuilder();
        while (currentNode != null){
            sb.append(currentNode.data);
            currentNode = currentNode.next;
            if (currentNode != null)
                sb.append(" -> ");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] arg){
        Queue<Integer> queue = new Queue<>();
        System.out.println("Size: " + queue.getSize());
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("Size: " + queue.getSize());
        queue.print();
        System.out.println("peek: " + queue.peek());
        System.out.println("pop: " + queue.dequeue());
        System.out.println("size: " + queue.getSize());
        queue.print();
    }
}
