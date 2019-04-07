package Searching;

import java.util.*;

/*
https://leetcode.com/problems/word-ladder/
 */

class WordNode{
    String word;
    int numSteps;

    public WordNode(String word, int numSteps){
        this.word = word;
        this.numSteps = numSteps;
    }
}
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<WordNode> queue = new LinkedList();
        queue.add(new WordNode(beginWord,1));
        wordList.add(endWord);

        while (!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;
            if(word.equals(endWord)){
                return top.numSteps;
            }
            char[] arr  = word.toCharArray();
            for(int i=0;i<arr.length;i++){
                char temp = arr[i];
                for(char ch='a';ch<='z';ch++){
                    if(arr[i]!=ch){
                        arr[i] = ch;
                    }
                    String newWord = new String(arr);
                    if(wordList.contains(newWord)){
                        queue.add(new WordNode(newWord,top.numSteps+1));
                        wordList.remove(newWord);
                    }
                }
                arr[i] = temp;
            }
        }
        return 0;
    }

    public static void main(String args[]){
        WordLadder wl  =new WordLadder();

        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};

        Set<String> wordList = new HashSet<>();
        Collections.addAll(wordList,Arrays.toString(words));
        wl.ladderLength(beginWord,endWord,wordList);

    }
}
