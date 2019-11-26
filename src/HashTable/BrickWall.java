package HashTable;

import java.util.*;

public class BrickWall {

    /*
    Bruteforce solution

       public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> hmap = new HashMap<>();
        
        
        for(List<Integer> row : wall) {
            int i = 1;
            hmap.put(0, Integer.MAX_VALUE);
            
            for(Integer brickWidth : row) {
                int j = brickWidth;
                for(j = brickWidth; j > 1; j--) {
                    hmap.put(i,hmap.getOrDefault(i,0)+1);  
                    i++;
                }
                if(j == 1) {
                    hmap.put(i,hmap.getOrDefault(i,0));     
                    i++;
                }
            }
            hmap.put(i-1, Integer.MAX_VALUE);
        }
        
        
        int min = Integer.MAX_VALUE;
        
        for(Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            if(entry.getValue() < min) {
                min = entry.getValue();
            }
        }
        
        if(hmap.size() == 2) {
            return wall.size();
        }
        return  min==Integer.MAX_VALUE ? 0 :min;
    }

    */
    public int leastBricks(List<List<Integer>> wall) {
        
        Map<Integer, Integer> hmap = new HashMap<>();
        int totalWidth = 0;
        
        for(List<Integer> row : wall) {
            int width = 0;
            for(Integer brickWidth : row) {
                width += brickWidth;
                hmap.put(width,hmap.getOrDefault(width,0)+1);
            }
            totalWidth = width;
        }
        
        
        int max = Integer.MIN_VALUE;
        
        for(Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            if(entry.getKey() == totalWidth) {
                continue;
            }
            if(entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        
        if(hmap.size() == 1) {
            return wall.size();
        }
        
        return  max==Integer.MIN_VALUE ? 0 : (wall.size()-max);
    }
}
