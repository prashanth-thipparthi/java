package DynamicProgramming;

import java.util.Arrays;

public class PerfectSquares {

    public int squares(int n){
       return squaresSum(n,1);
    }

    public int squaresSum(int n,int i){

       int a = (int)Math.sqrt(n);
       if(n-(a*a) == 0){
           return i;
       }
       return squaresSum(n-(a*a),i+1);
    }

    public int getMinSquares(int n)
    {
        // base cases
        if (n <= 3)
            return n;

        // getMinSquares rest of the table using recursive
        // formula
        int res = n; // Maximum squares required is
        // n (1*1 + 1*1 + ..)

        // Go through all smaller numbers
        // to recursively find minimumx
        for (int x = 1; x <= n; x++)
        {
            int temp = x*x;
            if (temp > n)
                break;
            else
                res =  Math.min(res, 1+getMinSquares(n - temp));
        }
        return res;
    }

    /*Dyanmic Programming*/
    public int numSquares(int n) {
        int squareRoot = (int)Math.sqrt(n); 
        int perfectSquares[] = new int[squareRoot];
        int dp[] = new int[n+1];
        
        Arrays.fill(dp,n+1);
        for(int i=1; i<=squareRoot; i++) {
            perfectSquares[i-1] = i*i;
        }
        
        dp[0] = 0;
        
        for(int i=1; i<=n; i++) {
            for(int square : perfectSquares)  {
                if(square > i) {
                    break;
                }else{
                    dp[i] = Math.min(dp[Math.max(0,i-square)]+1, dp[i]);
                }
            }   
        }
        return dp[n];
    }

    public static void main(String args[]){

        PerfectSquares ps = new PerfectSquares();
        //int n = ps.squares(41);

        System.out.println(ps.getMinSquares(9));

    }
}
