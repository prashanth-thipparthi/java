package Array;

public class ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        /*
        
        [
        [11,74,0,93],
        [40,11,74,7]]
        */
        
        for(int i=0; i<n; i++) {
            int ele = matrix[0][i];
            int index = 1;
            for(int j=i+1; (j<n && index <m);j++) {
                if(matrix[index++][j] != ele){
                   return false;
                }
            }
        }
        
        for(int i=0; i<m; i++) {
            int ele = matrix[i][0];
            int index = i+1;
            for(int j=1;(j<n && index <m);j++) {
                if(matrix[index++][j] != ele){
                    //System.out.println("i:"+i+"index:"+index+"j:"+j+"ele:"+ele);
                    return false;
                }
            }
        }
        return true;
    }
}