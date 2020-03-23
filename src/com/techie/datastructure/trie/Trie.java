package com.techie.datastructure.trie;

import java.util.HashMap;

public class Trie {

    class TrieNode{
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

    public void insert(String word){
        TrieNode current = this.root;
        for (int i = 0; i < word.length(); i++){
            char index = word.charAt(i);
            TrieNode node = current.children.get(index);
            if (node == null){
                node = new TrieNode();
                current.children.put(index, node);
            }
            current = node;
        }
        current.eof = true;
    }

    public boolean search(String word){
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++){
            char index = word.charAt(i);
            TrieNode node = current.children.get(index);
            if (node == null)
                return false;
            current = node;
        }

        return current.eof;
    }

    public boolean startsWith(String prefix){
        TrieNode current = this.root;

        for (int i = 0; i < prefix.length(); i++){
            char index = prefix.charAt(i);
            TrieNode node = current.children.get(index);
            if (node == null)
                return false;
            current = node;
        }
        return current.eof;
    }
}
