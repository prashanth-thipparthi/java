package Array;

/*https://leetcode.com/problems/diagonal-traverse/ */

public class DiagonalMatrixPrint_2 {

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new int[0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int output[] = new int[rows*cols];
        int row = 0,col = 0;
        for(int k=0;k<rows*cols;k++){
            output[k] = matrix[row][col];

            if ((row+col)%2 == 0) {
                if(col == cols-1){
                    row++;
                }else if(row == 0){
                    col++;
                }else{
                    row--;
                    col++;
                }
            }else{
                if(row == rows-1){
                    col++;
                }else if(col == 0){
                    row++;
                }else{
                    row++;
                    col--;
                }
            }
        }
        return output;
    }

    public static void main(String args[]){
        int matrix[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        DiagonalMatrixPrint_2 diagonalMatrixPrint = new DiagonalMatrixPrint_2();

        int output [] = diagonalMatrixPrint.findDiagonalOrder(matrix);

        for(int ele : output){
            System.out.print(ele+" ");
        }
    }
}
