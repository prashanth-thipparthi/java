package Searching.dfs;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ans = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return ans;

        int rows = matrix.length;
        int cols = matrix[0].length;
        /* auxMatrix acts as visited array as well as to store the answer i.e whether the
        water in the particular cell can reach both Atlantic and Pacific or not
        -1 = cell is unexplored
        0 = water in the cell cannot reach the oceans
        1 = water in the cell can reach the oceans
        */
        int[][] auxMatrix = new int[rows][cols];
        /*
        state[0] == pacific
        state[0] == atlantic
        */
        boolean[] state = null;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                auxMatrix[i][j] = -1;
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                state = new boolean[2];
                auxMatrix[i][j] = dfs(matrix, rows, cols, i, j, state, i , j, auxMatrix);
            }
        }
        List<Integer> l = null;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++) {
                if (auxMatrix[i][j] == 1) {
                    l = new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    ans.add(l);
                }
            }
        }
        return ans;
    }

    int dfs(int[][] matrix, int rows, int cols, int curRow, int curCol, boolean[] state, int i, int j, int[][] auxMatrix){

        if(i < 0 || i > rows || j < 0 || j> cols)
            return 0;

        if(i==0 || j == 0)
            state[0] = true;
        if(i==rows || j==cols)
            state[1] = true;

        if((state[0] == true && state[1] == true))
            return 1;

        if(i == rows || j == cols)
            return 0;

        if(auxMatrix[i][j] == 2)
            return 0;

        int temp = auxMatrix[i][j];
        auxMatrix[i][j] = 2;

        if(matrix[curRow][curCol] < matrix[i][j]) {
            auxMatrix[i][j] = temp;
            return 0;
        }

        boolean above = dfs(matrix, rows, cols, i, j, state, i-1 , j, auxMatrix) == 1 ? true : false;
        boolean below = dfs(matrix, rows, cols, i, j, state, i+1 , j, auxMatrix) == 1 ? true : false;
        boolean left = dfs(matrix, rows, cols, i, j, state, i , j-1, auxMatrix) == 1 ? true : false;
        boolean right = dfs(matrix, rows, cols, i, j, state, i , j+1, auxMatrix) == 1 ? true : false;
        auxMatrix[i][j] = temp;
        if(above || below || left || right)
            return 1;
        else
            return 0;
    }

    public static void main(String args[]){
        PacificAtlanticWaterFlow pawf = new PacificAtlanticWaterFlow();
        int[][] matrix = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        pawf.pacificAtlantic(matrix);
    }
}
