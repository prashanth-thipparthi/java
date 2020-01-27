package DynamicProgramming;

public class MinimumFallingPathSum {

 public int minFallingPathSum(int[][] A) {
    if(A.length == 1 && A[0].length ==1){
        return A[0][0];
    }
    
    int prev[] = new int[A[0].length];
    int cur[] = new int[A[0].length];
    
    for(int i=0; i<A[0].length; i++) {
        prev[i] = A[0][i];
    }
    
    for(int i=1; i<A.length; i++) {
        for(int j=0; j<A[0].length; j++) {
            cur[j] = Math.min(prev[Math.max(0,j-1)],Math.min(prev[j],prev[Math.min(j+1,A.length-1)])) + A[i][j];
        }
        prev = cur.clone();
    }        
    
    int min = Integer.MAX_VALUE;
    for(int i=0; i<A[0].length; i++) {
        if(cur[i] < min) {
            min = cur[i];
        }
    }
    
    return (min ==  Integer.MAX_VALUE) ? 0 : min;
 }
}