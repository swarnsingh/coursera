package com.datastructure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Swarn Singh.
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        TrieNode parent;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = Character.toUpperCase(word.charAt(i));
            TrieNode node = current.children.get(ch);

            if (node == null) {
                node = new TrieNode();
                node.parent = current;
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    private List<String> searchItems(String word) {
        List<String> items = new ArrayList<>();
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = root;
            if ( i > 0) {
                for ( int j = 0; j < 3; j++) {
                    node = current.children.get(ch);
                    if (node != null) {

                    }
                }
            }
        }

        return items;
    }

    public boolean search(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = Character.toUpperCase(word.charAt(i));
            TrieNode node = current.children.get(ch);

            if (node == null) {
                return false;
            }

            current = node;
        }
        return true;
    }

    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(TrieNode root, String word, int index) {
        int length = word.length();
        if (index < length && index >= 0) {
            char ch = Character.toUpperCase(word.charAt(index));

            TrieNode node = root;
            TrieNode child = node.children.get(ch);
            TrieNode parent = node.parent;

            if (node == null) {
                return false;
            }

            if (index < length - 1 && child.children.size() > 0) {
                delete(child, word, index + 1);
            } else {
                node.children.remove(ch);
                if (node.children.size() > 0) {
                    if (node.children.size() == 1) {
                        node.endOfWord = true;
                    }
                    return true;
                } else if (!node.endOfWord && parent.children.size() == 1) {
                    delete(parent, word, index - 1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("peter");
        trie.insert("piper");
        trie.insert("picked");
        trie.insert("peck");
        trie.insert("pickled");
        trie.insert("peppers");
        trie.insert("pie");
        trie.insert("piesum");
        trie.insert("piesut");

        System.out.println("Pickled is available : " + trie.search("pickled"));

        System.out.println("Pecked is available : " + trie.search("pecked"));

        System.out.println();

        trie.delete("pies");

        System.out.println("After Deletion of pies");

        System.out.println();

        System.out.println("piesum is available : " + trie.search("piesum"));

        System.out.println("piesu is available : " + trie.search("piesu"));

        System.out.println("pies is available : " + trie.search("pies"));

        System.out.println("pie is available : " + trie.search("pie"));

        System.out.println("piesut is available : " + trie.search("piesut"));

        System.out.println("pi is available : " + trie.search("pi"));
    }

}
