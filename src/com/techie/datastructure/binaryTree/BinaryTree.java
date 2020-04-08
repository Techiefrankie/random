package com.techie.datastructure.binaryTree;

import com.techie.datastructure.queue.Queue;

public class BinaryTree<T extends Comparable<T>> {

    static class Node<T extends Comparable<T>>{
        Node parent;
        Node left;
        Node right;
        T data;

        public Node(T data) {
            this.data = data;
            this.parent = null;
            this.left = null;
            this.right = null;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    Node root;
    int size;

    public BinaryTree(Node root) {
        this.root = root;
        this.size = 0;
    }

    int getSize(){
        return this.size;
    }

    void add(Node node){
        //first node to be added

        if (this.root == null){
            this.root = node;
        }
        else{
            //insert node
            insert(node, root);
        }
    }

    private void insert(Node child, Node parent) {
        int comparator = child.data.compareTo(parent.data);

        if (comparator < 0){
            //insert at left
            if (parent.left == null){
                parent.left = child;
                child.parent = parent;
                size++;
            }
            else {
                insert(child, parent.left);
            }
        }
        else  if (comparator > 0){
            //insert at right
            if (parent.right == null){
                parent.right = child;
                child.parent = parent;
                size++;
            }
            else {
                insert(child, parent.right);
            }
        }
    }

    void bfs(Node root){

    }

    public static void main(String[] arg){
        Node<Integer> root = new Node(5);
        Node<Integer> a = new Node(5);
        Node<Integer> b = new Node(5);
        Node<Integer> c = new Node(5);
        Node<Integer> d = new Node(5);
        BinaryTree<Integer> tree = new BinaryTree<>(root);
        tree.add(a);
        tree.add(b);
        tree.add(c);
        tree.add(d);
    }
}
