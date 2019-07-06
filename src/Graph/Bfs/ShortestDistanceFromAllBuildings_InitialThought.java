package Graph.Bfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] ans = new int[rows][cols];
        int minimumDistance = Integer.MAX_VALUE;

        Queue<int[]> mainQueue = new LinkedList<>();
        Queue<int[]> bfsQueue = new LinkedList<int[]>();

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    mainQueue.offer(new int[]{i,j});
                }
            }
        }

        int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

        while(! mainQueue.isEmpty()){
            int[] point = mainQueue.poll();
            bfsQueue.offer(point);

            while(!bfsQueue.isEmpty()){
                int[] bfspoint = bfsQueue.poll();
                for(int i=0; i<4; i++){
                    int xx = bfspoint[0] + directions[i][0];
                    int yy = bfspoint[1] + directions[i][1];

                    if(xx<0 ||xx >= rows || yy<0 || yy>= cols ||
                            grid[xx][yy] != 0){
                        continue;
                    }

                    if(grid[xx][yy] > grid[bfspoint[0]][bfspoint[1]] + 1){
                        grid[xx][yy] = grid[bfspoint[0]][bfspoint[1]] + 1;
                        bfsQueue.offer(new int[]{xx,yy});
                    }

                }
            }
            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    if(ans[i][j] != Integer.MIN_VALUE)
                        ans[i][j] += grid[i][j];
                }
            }

            for(int i=0; i<rows; i++){
                for(int j=0; j<cols; j++){
                    if(ans[i][j] == Integer.MIN_VALUE)
                        continue;
                    minimumDistance = Math.min(minimumDistance, ans[i][j]);
                }
            }
        }
        return minimumDistance;
    }

    public static void main(String args[]){
        ShortestDistanceFromAllBuildings sdfb = new ShortestDistanceFromAllBuildings();
        int[][] area = new int[][]{{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        System.out.println("dis : "+sdfb.shortestDistance(area));
    }
}
