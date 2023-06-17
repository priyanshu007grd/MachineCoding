package com.priyanshusharan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Trie trie =  new Trie();

        trie.insert(List.of("aa","bb","cc"));
        trie.insert(List.of("aa","bb","cc","dd"));

        System.out.println(trie.search(List.of("aa")));
        System.out.println(trie.search(List.of("aa","bb")));
        System.out.println(trie.search(List.of("aa","bb","cc")));
        System.out.println(trie.search(List.of("aa","bb","cc","dd")));
        System.out.println(trie.search(List.of("aa","dd")));

        trie.remove(List.of("aa","bb","cc"));
        System.out.println(trie.search(List.of("aa")));
        System.out.println(trie.search(List.of("aa","bb")));
        System.out.println(trie.search(List.of("aa","bb","cc")));
        System.out.println(trie.search(List.of("aa","bb","cc","dd")));
        System.out.println(trie.search(List.of("aa","dd")));
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root=null;
    }

    void insert(List<String> tags) {

        if(root==null) root = new TrieNode();
        TrieNode temp=root;

        for(String tag:tags) {
            temp.count+=1;
            temp.m.putIfAbsent(tag,new TrieNode());
            temp = temp.m.get(tag);
        }
        temp.count+=1;
    }

    Integer search(List<String> tags) {

        if(root==null) return 0;

        TrieNode temp = root;
        for(String tag:tags) {
            temp = temp.m.getOrDefault(tag,null);
            if(temp==null) return 0;
        }
        return temp.count;
    }

    void remove(List<String> tags) {

        if(root==null) return;
        TrieNode temp=root;

        for(String tag:tags) {
            temp.count-=1;
            temp = temp.m.getOrDefault(tag,null);
            if(temp==null) return;
        }
        temp.count-=1;
        return;
    }
}



class TrieNode {
    int count;
    Map<String,TrieNode> m;

    public TrieNode() {
        count=0;
        m=new HashMap<>();
    }
}