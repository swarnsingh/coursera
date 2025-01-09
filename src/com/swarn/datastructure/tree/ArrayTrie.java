package com.swarn.datastructure.tree;

import java.util.*;

/**
 * This class implements a Trie (prefix tree) data structure using an array of TrieNodes.
 * It supports insertion and searching of words.
 *
 * @author Swarn Singh
 */
public class ArrayTrie {
    private final TrieNode root;

    /**
     * Constructs an empty ArrayTrie.
     */
    public ArrayTrie() {
        root = new TrieNode();
    }

    /**
     * Represents a single node in the Trie.
     */
    private static class TrieNode {
        TrieNode[] children;
        boolean endOfWord;

        /**
         * Constructs a TrieNode with an array of 26 children (one for each letter).
         */
        public TrieNode() {
            children = new TrieNode[26];
            endOfWord = false;
        }
    }

    /**
     * Inserts a word into the Trie.
     *
     * @param word the word to insert
     */
    public void insert(String word) {
        word = word.toLowerCase();
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index]; // Move to the next node
        }
        current.endOfWord = true;
    }

    /**
     * Searches for a word in the Trie.
     *
     * @param word the word to search for
     * @return true if the word exists in the Trie, false otherwise
     */
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

    /**
     * Inserts an array of words into the Trie.
     *
     * @param words the array of words to insert
     */
    public void insertAll(String[] words) {
        for (String word : words) {
            insert(word);
        }
    }

    public static void main(String[] args) {
        ArrayTrie trie = new ArrayTrie();
        String[] words = {"pie", "piesum", "pies", "pieset", "trojan", "troy", "trophy", "troop"};
        trie.insertAll(words);

        System.out.println("Pi is available : " + trie.search("pi"));
        System.out.println("Piesum is available : " + trie.search("Piesum"));
    }
}
