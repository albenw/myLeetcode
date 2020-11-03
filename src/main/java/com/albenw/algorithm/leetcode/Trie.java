package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author alben.wong
 * @since 2020/10/11.
 * leetcode 208
 * 实现字典树
 */
@Slf4j
public class Trie {

    static class TreeNode{
        private char val;
        private TreeNode[] children = new TreeNode[26];
        private boolean isWord;
        public TreeNode(){};
        public TreeNode(char c){
            TreeNode node = new TreeNode();
            node.val = c;
        }
    }

    private TreeNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode('^');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.length() == 0){
            return;
        }
        TreeNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TreeNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word.length() == 0){
            return false;
        }
        TreeNode node = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null){
                return false;
            }
            node = node.children[c - 'a'];
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0){
            return false;
        }
        TreeNode node = root;
        for (int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(node.children[c - 'a'] == null){
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }

    @Test
    public void test1(){
        Trie trie = new Trie();
        trie.insert("alben");
        trie.insert("wong");
        boolean alben = trie.search("alben");
        log.info("search={}", alben);
        boolean wo = trie.startsWith("wo");
        log.info("startsWith={}", wo);
    }

}
