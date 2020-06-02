package Heap;

import java.util.*;

/*
https://leetcode.com/discuss/interview-question/542597/

\\w+ matches all alphanumeric characters and _.
\\W+ matches all characters except alphanumeric characters and _.

*/
public class TopKFrequentlyMentionedKeywords {
    public List<String> TopKFrequentlyMentionedKeywords(String[] keyWords, String[] reviews, int k) {
        List<String> ans = new ArrayList();
        Set<String> keyWordsSet = new HashSet<String>();
        for(String keyword:keyWords) {
            keyWordsSet.add(keyword.toLowerCase());
        }
        Map<String,Integer> hmap = new HashMap<>();
        for(String review : reviews) {
            String[] reviewWords = review.split("\\W");
            Set<String> hashSet = new HashSet<String>();
            for(String word:reviewWords){
                hashSet.add(word.toLowerCase());
            }            
            for(String key:keyWordsSet){
                if(hashSet.contains(key)){
                    hmap.put(key,hmap.getOrDefault(key,0)+1);
                }
            }
        }

        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue(new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b){
                return a.getValue() == b.getValue() ? a.getKey().compareToIgnoreCase(b.getKey()) : a.getValue() - b.getValue();
            }
        });

        for(Map.Entry<String,Integer> entry : hmap.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        while(minHeap.size() > 0) {
            ans.add(0,minHeap.poll().getKey());
        }
        return ans;
    }

    public static void main(String args[]) {
        TopKFrequentlyMentionedKeywords topKFreq = new TopKFrequentlyMentionedKeywords();
        String keywords[] = new String[] {"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String reviews[] = new String[] {"I love anacell Best services; Best services provided by anacell",
        "betacellular has great services",
        "deltacellular provides much better services than betacellular",
        "cetracular is worse than anacell",
        "Betacellular is better than deltacellular."};
        int k = 2;
        List<String> ans = topKFreq.TopKFrequentlyMentionedKeywords(keywords, reviews, k);

        for(String freqWord:ans) {
            System.out.println(freqWord);
        }
    }
}