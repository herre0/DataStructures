package com.mert.Trie;

import java.util.*;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < children.length; i++) {
                if (children[i] != null)
                    sb.append((char) (i + 'a') + " ");
            }
            return sb.toString();
        }

    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    void printTrie() { // doesn't work , you sure? za xd

        Queue<TrieNode> que = new LinkedList();
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                que.offer(root.children[i]);
            }
        }

        while (!que.isEmpty()) {
            int size = que.size();
            while (size > 0) {
                TrieNode curNode = que.poll();

                for (int i = 0; i < 26; i++) {
                    if (curNode.children[i] != null) {
                        que.offer(curNode.children[i]);
                        System.out.print(curNode.children[i]);
                    }
                }
            }
            System.out.println();
        }

    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null)
                return false;
            node = node.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("cat");
        trie.insert("car");
        trie.insert("carpenter");

        System.out.println(trie.search("app"));
        System.out.println(trie.search("application"));
        System.out.println(trie.startsWith("ap"));
        trie.printTrie();
    }

}
