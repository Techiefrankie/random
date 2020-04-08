package com.techie.datastructure.trie;

import java.util.HashMap;

class Trie {
    class TrieNode {
        HashMap<Character, TrieNode> children;
        boolean eof;

        public TrieNode() {
            this.children = new HashMap<>();
            this.eof = false;
        }
    }

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    void add(String word) {
        //grab the root Trie node
        TrieNode currentNode = root;
        //loop through all the characters in the string to be added
        for (char character : word.toCharArray()) {
            //check if the current node already contains this character, else add this character to a new node
            TrieNode node = currentNode.children.get(character);
            TrieNode newNode = new TrieNode();
            if (node == null) {
                currentNode.children.putIfAbsent(character, newNode);
            }
            // update the current node to the new node
            currentNode = newNode;
        }
        //set eof to true at the end of the traversal
        currentNode.eof = true;
    }

    boolean contains(String word) {
        //grab the root node
        TrieNode currentNode = root;
        //loop through every character in the word to see if the eof flag of the last character is true
        for (char character : word.toCharArray()) {
            TrieNode node = currentNode.children.get(character);
            if (node.eof == true)
                return false;//no path for this word
            currentNode = node; //to advance the loop
        }
        return currentNode.eof;//true if word exists, false otherwise
    }

    void print() {
        StringBuilder sb = new StringBuilder();
        TrieNode currentNode = root;
        TrieNode[] nodes = currentNode.children.entrySet().toArray(TrieNode[]::new);
        for (TrieNode node : nodes) {
            TrieNode node1 = node;
        }

        while (currentNode != null && !currentNode.eof) {
            char character = currentNode.children.keySet().iterator().next();
            sb.append(character);
            currentNode = currentNode.children.get(character);
            if (!currentNode.eof) sb
                    .append(" -> ");
        }
        System.out.println(sb.toString());
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("Techiefrankie");
        trie.print();
        trie.add("eiknarfeihceT");
        trie.print();
    }
}
