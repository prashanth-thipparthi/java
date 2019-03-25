package Array;

// Java program to print a given matrix in spiral form
import java.io.*;

class SpiralMatrix
{

    public void print(int matrix[][],int row,int column){
        int first_row=0,first_column=0;
        int last_row = row-1,last_column=column-1;

        while(first_row<=last_row && first_column<=last_column){

            for(int i=first_column;i<=last_column;i++){
                System.out.println(matrix[first_row][i]);
            }
            first_row++;

            for(int i=first_row;i<=last_row;i++){
                System.out.println(matrix[i][last_column]);
            }
            last_column--;

            if(first_row<= last_row){
                for(int i=last_column;i>=first_column;i--){
                    System.out.println(matrix[last_row][i]);
                }
            }
            last_row--;

            if(first_column<=last_column){
                for(int i=last_row;i>=first_row;i--){
                    System.out.println(matrix[i][first_column]);
                }
            }
            first_column++;
        }
    }
    // driver program
    public static void main (String[] args)
    {
        int row = 4;
        int column = 6;
        int a[][] = { {1,  2,  3,  4,  5,  6},
                {7,  8,  9,  10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24}
        };

        SpiralMatrix sm = new SpiralMatrix();

        sm.print(a,row,column);
    }
}