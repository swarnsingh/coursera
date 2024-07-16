package com.swarn.datastructure.tree;

public class ArrayTrie {
    private final TrieNode root;

    public ArrayTrie() {
        root = new TrieNode();
    }

    private static class TrieNode {
        TrieNode[] children;
        boolean endOfWord;

        public TrieNode() {
            children = new TrieNode[26];
            endOfWord = false;
        }
    }

    public void insert(String word) {
        word = word.toLowerCase();
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            } else {
                current = current.children[index];
            }
        }
        current.endOfWord = true;
    }

    public boolean search(String word) {
        word = word.toLowerCase();
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.endOfWord;
    }
}
