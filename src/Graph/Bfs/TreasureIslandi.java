package Graph.Bfs;

import java.util.LinkedList;
import java.util.Queue;

/*https://leetcode.com/discuss/interview-question/347457/Amazon-or-OA-2019-or-Treasure-Island */
public class TreasureIslandi {
/*
{'O', 'O', 'O', 'O'},
 {'D', 'O', 'D', 'O'},
 {'O', 'O', 'O', 'O'},
 {'X', 'D', 'D', 'O'}
 */

    public int islandPath(char[][] island){

        int m = island.length;
        int n = island[0].length;

        int visited[][] = new int[m][n];

        Queue<int[]> bfs = new LinkedList<int[]>();

        bfs.offer(new int[]{0,0});
        int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int steps = 0;
        bfs.offer(null);
        while(!bfs.isEmpty()){
            int [] point = bfs.poll();
            steps++;
            while(point != null){
                for(int[] dir : directions){
                    if(dir[0]+point[0] >= 0 && dir[0]+point[0] < m && dir[1]+point[1] >= 0 && dir[1]+point[1] < n && island[dir[0] + point[0]][dir[1] + point[1]] == 'D') {
                        if (island[dir[0] + point[0]][dir[1] + point[1]] == 'X') {
                            return steps;
                        }
                        bfs.offer(new int[]{dir[0] + point[0], dir[1] + point[1]});
                    }
                }
                point = bfs.poll();
            }
            bfs.offer(null);
        }
        return 0;
    }

    public static void main(String args[]){

        char[][] island = new char[][]{{'O', 'O', 'X', 'O'},
                                        {'D', 'O', 'D', 'O'},
                                        {'O', 'O', 'O', 'O'},
                                        {'O', 'D', 'D', 'O'}};
        TreasureIslandi ti = new TreasureIslandi();
        System.out.println(ti.islandPath(island));
    }
}
