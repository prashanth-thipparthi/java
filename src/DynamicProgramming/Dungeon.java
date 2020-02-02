package DynamicProgramming;

public class Dungeon{
    public int calculateMinimumHP(int[][] dungeon) {
        
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        
        dungeon[rows-1][cols-1] = dungeon[rows-1][cols-1] > 0 ? 1 : Math.abs(dungeon[rows-1][cols-1]) + 1;
        
        for(int i=rows-2; i>=0; i--) {
            dungeon[i][cols-1] = Math.max(dungeon[i+1][cols-1]-dungeon[i][cols-1],1);
        }
        
        for(int i=cols-2; i>=0; i--) {
            dungeon[rows-1][i] = Math.max(dungeon[rows-1][i+1]-dungeon[rows-1][i],1);
        }
        
        for(int i=rows-2; i>=0; i--){
            for(int j=cols-2; j>=0; j--){
                dungeon[i][j] = Math.max(Math.min(dungeon[i+1][j], dungeon[i][j+1])-dungeon[i][j],1);
            }            
        }
        
        return dungeon[0][0];
    }
}