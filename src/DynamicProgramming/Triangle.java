package DynamicProgramming;

import java.util.*;

public class Triangle {
    /*
    Adjacent Number:
    The adjacent number of i in this row is i and i+1 in the next row.
    */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) {
            return 0;
        }
        
        int cur[] = new int[triangle.size()];
        int prev[] = new int[triangle.size()];
        
        prev[0] = triangle.get(0).get(0);
        
        for(int i=1; i<triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            int lastRowSize = triangle.get(i-1).size();
            for(int j=0; j<list.size(); j++) {
                cur[j] = Math.min(prev[Math.max(0,j-1)],prev[Math.min(j,lastRowSize-1)]) + list.get(j);
            }
            prev = cur.clone();
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int number : prev) {
            //System.out.println(number);
            if(min > number) {
                min = number;
            }
        }
        
        return min==Integer.MAX_VALUE ? 0 : min;
    }
}