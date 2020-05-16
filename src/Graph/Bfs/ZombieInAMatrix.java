package Graph.Bfs;
import java.util.*;

/*
https://leetcode.com/discuss/interview-question/411357/
*/
public class ZombieInAMatrix {
    int minHours(int rows, int columns, List<List<Integer>> grid) {
        // todo
        if(grid == null || grid.size() == 0 ){
            return 0;
        }
        Queue<int[]> bfs = new LinkedList<int[]>();
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0; i<rows; i++){
            List<Integer> row = grid.get(i);
            for(int j=0; j < columns; j++) {
                int element = row.get(j);
                if(element == 1){
                    bfs.offer(new int[]{i,j});
                }
            }
        }

        int time = 0;
        while(bfs.size() > 0){
            ++time;
            int level_size = bfs.size();
            for(int i=0; i<level_size; i++) {
                int[] point = bfs.remove();
                for(int[] xy : directions) {
                    int x = point[0] + xy[0];
                    int y = point[1] + xy[1];

                    if(x<0 || y<0 || x >= rows || y >= columns || grid.get(x).get(y) == 1){
                        continue;
                    }
                    grid.get(x).get(y) = 1;
                    bfs.offer(new int[]{x,y});
                }
            }
        }        
        return time-1;
    }
}