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

    /*
    recursive insert
     */

    public void insertRecursive(String word){
        int index = 0;
        insertRecursive(word,root,index);
    }

    public boolean insertRecursive(String word, TrieNode current,int index){
        if(index == word.length()){
            current.isEnd = true;
            return true;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);

        if(node==null){
            node = new TrieNode();
            current.children.put(ch,node);
        }

        insertRecursive(word,node,index+1);
        return false;
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

    /*
    recursive implementation of search
     */

    public void recursiveSearch(String word){
        int index = 0;
        recursiveSearch(word,root,index);
    }

    public boolean recursiveSearch(String word, TrieNode current, int index){

        if(index == word.length()){
            return current.isEnd;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node == null){
            return false;
        }
        return recursiveSearch(word,node,index+1);
    }

    public boolean deleteWord(String word){
        int index = 0;
        return delete(word,root,index);
    }

    public boolean delete(String word,TrieNode current,int index){
        if(index == word.length()){
            if(!current.isEnd){
                return false;
            }

            current.isEnd = false;
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node==null){
            return false;
        }

        boolean curentNodeDeleteCondition = delete(word,node,index+1);

        if(curentNodeDeleteCondition){
            current.children.remove(ch);
            return current.children.size() == 0;
        }
        return false;
    }

    public static void main(String args[]){
        Trie t = new Trie();
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};
        for(int i=0;i<keys.length;i++){
            //t.insert(keys[i]);
            t.insertRecursive(keys[i]);
        }

        System.out.println("Word Found:"+t.search("there"));

        System.out.println("String Delete Condition:"+t.deleteWord("there"));

        System.out.println("Word Found:"+t.search("there"));
    }

}
