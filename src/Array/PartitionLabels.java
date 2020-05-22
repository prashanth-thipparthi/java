package Array;

import java.util.*;

  /*
Imagine a bus moving forward, and imagine each char as a person yelling "I need to go that far!". If a newcomer yelled a further 
position, we extend our expected ending position to that position. Eventually, if we reached a position that satisfied everybody 
in the bus at the moment, we partition and clear the bus.
*/
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        //Map<Character,Integer> hmap = new HashMap<>();
        int map[] = new int[26];
        char ch[] = S.toCharArray();
        int len = ch.length;
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<len; i++)  {
            map[ch[i]-'a'] = i+1;
        }
    
        int last = 0;
        int start = 0;
        for(int i=0; i<len; i++) {
            last = Math.max(last,map[ch[i]-'a']);
            if(last == i+1) {
                answer.add(last-start);
                start = i+1;
            }
        }
        return answer;
    }
}