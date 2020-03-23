package com.techie.datastructure.trie;

public class Driver {

    public static void main(String[] args){
        Trie trie = new Trie();
        String  word = "Techiefrankie";
        trie.insert(word);
        System.out.println(trie.search(word));
    }
}
