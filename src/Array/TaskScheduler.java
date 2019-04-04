package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n){
        HashMap<Character,Integer> hmap = new HashMap<>();

        for(Character ch :tasks){
            /*
            if(!hmap.containsKey(ch)){
                hmap.put(ch,1);
            }else{
                hmap.put(ch,hmap.get(ch)+1);
            }*/
            hmap.put(ch,hmap.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->(b-a));

        maxHeap.addAll(hmap.values());

        int cycles = 0;

        while(!maxHeap.isEmpty()){
            List<Integer> temp = new ArrayList<>();

            for(int i=0;i<n+1;i++){
                if(!maxHeap.isEmpty()){
                    temp.add(maxHeap.remove());
                }
            }

            for(int i:temp){
                if(--i>0){
                    maxHeap.add(i);
                }
            }

            cycles += maxHeap.isEmpty()?temp.size():n+1;
        }
        return cycles;
    }

    public static void main(String args[]){
        char tasks [] = {'A','A','A','B','B','B'};
        int n =2;

        TaskScheduler ts = new TaskScheduler();

        ts.leastInterval(tasks,2);
    }
}
