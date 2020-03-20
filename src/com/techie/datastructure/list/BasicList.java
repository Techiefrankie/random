package com.techie.datastructure.list;

public class BasicList<T> {
    private Node first;
    private Node last;
    private int nodeCount;

    public BasicList() {
        this.first = null;
        this.last = null;
        this.nodeCount = 0;
    }

    public  int size(){
        return this.nodeCount;
    }

    public void add(T item){
        if (first == null){
            first = new Node(item);
            last = first;
        }
        else{
            last = new Node(item);
            last.setNextNode(last);
        }
        nodeCount++;
    }

    public void insert(T item, int position){
        if (position < 1 || position > size()) throw  new IllegalStateException("Position out of bounds");

        Node currentNode = first;
        for (int i = 1; i < position && currentNode != null; i++){
            currentNode = currentNode.getNextNode();
        }

        //chain nodes
        Node newNode = new Node(item);
        Node nextNode = currentNode.getNextNode();
        currentNode.setNextNode(newNode);
        newNode.setNextNode(nextNode);
        nodeCount++;
    }

    public T removeAt(int position){
        if (position < 1 || position > size()) throw  new IllegalStateException("Position out of bounds");


        Node prevNode = first;
        Node currentNode = first;
        for (int i = 1; i < position && currentNode != null; i++){
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        //chain nodes
        T item = (T) currentNode.getNodeItem();
        Node nextNode = currentNode.getNextNode();
        prevNode.setNextNode(currentNode.getNextNode());
        nodeCount--;
        return item;
    }

    public T remove(){
        if (first == null)
            throw new IllegalStateException("LinkedList is empty");
        T item = (T) first.getNodeItem();
        //update first node
        first = first.getNextNode();
        nodeCount--;
        return item;
    }

    public T get(int position){
        if (first == null) throw new IllegalStateException("Linked list is empty");
        Node currentNode = first;

        for (int i = 0; i < size() && currentNode != null; i++){
            if (i == position) return (T) currentNode.getNodeItem();
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    public int find(T item){
        if (first == null) throw new IllegalStateException("Linked list is empty");
        Node currentNode = first;
        for (int i = 0; i < size() && currentNode != null; i++){
            if (currentNode.getNodeItem() == item) return i;
            currentNode = currentNode.getNextNode();
        }
        return  -1;
    }

    public String toString(){
        StringBuffer contents = new StringBuffer();

        Node currentNode = first;

        while (currentNode != null){
            contents.append(currentNode.getNodeItem());
            currentNode = currentNode.getNextNode();
            if (currentNode != null) contents.append(" -> ");
        }
        return  contents.toString();
    }

}
