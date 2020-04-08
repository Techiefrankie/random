package com.techie.datastructure.stack;

public class Stack<T>{

    class Node<T>{
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    Node top;
    int size;

    public Stack() {
        this.top = null;
        size = 0;
    }

    int getSize(){
        return this.size;
    }

    void push(T item){
        Node node = new Node(item);
        node.next = top;
        top = node;
        size++;
    }

    T pop(){
        if (top == null)
            throw new  IllegalStateException("Stack is empty");
        Node temp = top;
        top = top.next;
        size--;
        return (T) temp.data;
    }

    T peek(){
        return (T)top.data;
    }

    void print(){
        Node currentNode = top;
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
        Stack<Integer> stack = new Stack<>();
        System.out.println("Size: " + stack.getSize());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Size: " + stack.getSize());
        stack.print();
        System.out.println("peek: " + stack.peek());
        System.out.println("pop: " + stack.pop());
        System.out.println("size: " + stack.getSize());
        stack.print();
    }
}

