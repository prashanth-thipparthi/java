package Trees;

/*
03/19/2019
 */

import java.util.HashMap;
import java.util.Map;

public class Trie {

    private class TrieNode{
        Map<Character,TrieNode> children;
        boolean isEnd;

        public TrieNode(){
            children = new HashMap<>();
            isEnd = false;
        }
    }

    private final TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            Character ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch,node);
            }
            current = node;
        }
        current.isEnd = true;
    }

    public boolean search(String word){

        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            Character ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                return false;
            }
            current = node;
        }
        return current.isEnd;
    }

    public static void main(String args[]){
        Trie t = new Trie();
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};
        for(int i=0;i<keys.length;i++){
            t.insert(keys[i]);
        }

        System.out.println("Word Found:"+t.search("b"));
    }

}
