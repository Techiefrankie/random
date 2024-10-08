package com.techie.datastructure.list;

public class Node<E> {
    private E nodeItem;
    public Node nextNode;

    public Node(E nodeItem) {
        this.nodeItem = nodeItem;
        this.nextNode = null;
    }

    public E getNodeItem() {
        return nodeItem;
    }

    public void setNodeItem(E nodeItem) {
        this.nodeItem = nodeItem;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
