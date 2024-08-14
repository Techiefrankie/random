package com.techie.datastructure.binaryTree;

import java.util.*;

public class BTree {
    // first node
    private Node root;
    BTree(){
        root = null;
    }

    // Class representing tree nodes
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    public void insert(int item){
        root = insert(root, item);
    }

    //Inserting node - recursive method
    public Node insert(Node node, int value){
        if(node == null){
            return new Node(value);
        }
        // Move to the left if passed value is
        // less than the current node
        if(value < node.data){
            node.left = insert(node.left, value);
        }
        // Move to the right if passed value is
        // greater than the current node
        else if(value > node.data){
            node.right = insert(node.right, value);
        }
        return node;
    }

    // Method to get height of the tree
    public int calculateTreeHeight(Node root){
        if(root == null){
            return 0;
        }
        else{
            // height of left subtree
            int lsh = calculateTreeHeight(root.left);
            // height of right subtree
            int rsh = calculateTreeHeight(root.right);
            // height in each recursive call
            return Math.max(lsh, rsh) + 1;
        }
    }

    public void levelOrder(){
        int height = calculateTreeHeight(root);
        for(int i = 0; i < height; i++){
            bfs(root, i);
        }
    }

    // Recursive Method for breadth first search
    public void bfs(Node node, int level){
        if(node == null){
            return;
        }
        if(level == 0){
            System.out.print(node.data + " ");
        }
        else{
            bfs(node.left, level-1);
            bfs(node.right, level-1);
        }
    }

    // Iterative method for breadth first search
    public void bfs(Node root){
        if(root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new LinkedHashSet<>();

        Node previous = root, next = null;
        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            previous = node;

            if(node.left != null){
                queue.add(node.left);
                next = node.left;
            }
            if(node.right != null){
                queue.add(node.right);
                next = node.right;
            }
            visited.add(previous.data + next.data);
            System.out.print(node.data + " ");
        }
        System.out.println("\nMax sum path: " + Collections.max(visited));
    }

    // Iterative method for depth first search
    public void dfs(Node root){
        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Set<Integer> visited = new LinkedHashSet<>();

        Node previous = root, next = null;
        stack.add(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            previous = node;

            if(node.left != null){
                stack.add(node.left);
                next = node.left;
            }
            if(node.right != null){
                stack.add(node.right);
                next = node.right;
            }
            visited.add(previous.data + next.data);
            System.out.print(node.data + " ");
        }
        System.out.println("\nMax sum path: " + Collections.max(visited));
    }

    public boolean isBST(Node node) {
        return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.data <= min || node.data >= max) {
            return false;
        }

        return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
    }

    public static void main(String[] args) {
        BTree bst = new BTree();
        bst.insert(50);
        bst.insert(70);
        bst.insert(30);
        bst.insert(15);
        bst.insert(35);
        bst.insert(7);
        bst.insert(22);
        bst.insert(31);
        bst.insert(62);
        bst.insert(87);

        System.out.println("Height- " + bst.calculateTreeHeight(bst.root));
        System.out.println("Level order traversal recursive");
        bst.levelOrder();
        System.out.println("");
        System.out.println("Level order traversal iterative");
        bst.bfs(bst.root);
        System.out.println("Depth first search iterative");
        bst.dfs(bst.root);
        System.out.println("");
    }
}


