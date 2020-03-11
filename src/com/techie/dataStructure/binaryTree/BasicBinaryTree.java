package com.techie.dataStructure.binaryTree;

public class BasicBinaryTree<T extends Comparable<T>> {
    private Node root;
    private int size;

    public BasicBinaryTree(Node root) {
        this.root = root;
        size = 0;
    }

    public  void add(T item){
        Node node = new Node(item);

        if (root == null){
            root = node;
            size++;
        }
        else{
            insert(root, node);
        }
    }

    private void insert(Node parent, Node child) {
        //if child is less than parent, it goes to left
        if (child.getItem().compareTo(parent.getItem()) < 0){
            if (child.getLeft() == null){
                child.setParent(parent);
                parent.setLeft(child);
                size++;
            }
            else {
                insert(parent,child);
            }
        }
        else if (child.getItem().compareTo(parent.getItem()) > 0){
            //push to the right
            if (child.getRight() == null){
                child.setParent(parent);
                parent.setRight(child);
                size++;
            }
            else{
                insert(parent, child);
            }
        }
    }

    public Node contains(T item){
        if (root == null)
            throw new IllegalStateException("Binary tree is empty");
        return get(item);
    }

    public boolean delete(T item){
        boolean deleted = false;
        //if tree is empty
        if (this.root == null)
            return false;
        Node currentNode = get(item);

        if (currentNode != null){
            //has no left nor right nodes
            if (currentNode.getLeft() == null && currentNode.getRight() == null) {
                unlink(currentNode, null);
                deleted = true;
            }
            else if (currentNode.getLeft() == null && currentNode.getRight() != null){
                //has only right node
                unlink(currentNode, currentNode.getRight());
                deleted = true;
            }
            else if (currentNode.getLeft() != null && currentNode.getRight() == null){
                //has only left node
                unlink(currentNode, currentNode.getLeft() );
                deleted = true;
            }
            else {
                //node has both left and right nodes
                Node child = currentNode.getLeft();
                while (child.getRight() != null && child.getLeft() != null){
                    //get the right most leaf
                    child = child.getRight();
                }
                //remove leaf from its current  position
                child.getParent().setRight(null);
                child.setRight(currentNode.getRight());
                child.setLeft(currentNode.getLeft());

                unlink(currentNode, child);
                deleted = true;
            }
        }
        if (deleted) this.size--;

        return deleted;
    }

    public void unlink(Node currentNode, Node newNode){
        if (currentNode == this.root){
            this.root = newNode;
            newNode.setRight(currentNode.getRight());
            newNode.setLeft(currentNode.getLeft());
        }
        if (currentNode.getParent().getLeft() == currentNode){
            currentNode.getParent().setLeft(newNode);
        }
        else if(currentNode.getParent().getRight() == currentNode){
            currentNode.getParent().setRight(newNode);
        }
    }

    private Node get(T item){
        Node currentNode = this.root;
        while (currentNode != null){
            int val = item.compareTo((T) currentNode.getItem());
            if (val == 0){
                return  currentNode;
            }
            else if(val < 0){
                currentNode = currentNode.getLeft();
            }
            else {
                currentNode = currentNode.getRight();
            }
        }
        return null;
    }
}
