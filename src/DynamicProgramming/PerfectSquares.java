package DynamicProgramming;

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

    public static void main(String args[]){

        PerfectSquares ps = new PerfectSquares();
        //int n = ps.squares(41);

        System.out.println(ps.getMinSquares(9));

    }
}
