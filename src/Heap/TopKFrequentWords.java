package Heap;

import java.util.*;

class Pair implements Comparable<Pair> {
    String word;
    int count;

//     public void Pair(){
        
//     }
    public void Pair(String word,Integer count){
        this.word = word;
        this.count = count;
    }

    public int compareTo(Pair p){
        if(this.count == p.count){
            return p.word.compareTo(this.word);
        }
        return this.count-p.count;
    }
}
class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList();
        if(words.length == 0){
            return ans;
        }
        Map<String,Integer> hmap = new HashMap<String,Integer>();
        
        for(String word : words) {
            hmap.put(word,hmap.getOrDefault(word,0)+1);
        }
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>();
        
        for(Map.Entry<String, Integer> entry : hmap.entrySet()) {
            //System.out.println("key:"+entry.getKey()+" value:"+entry.getValue());
            Pair p = new Pair();
            p.word = entry.getKey();
            p.count = entry.getValue();
            minHeap.offer(p);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        while(minHeap.size()>0){
            ans.add(0,minHeap.poll().word);
        }
        return ans;
    }
}
