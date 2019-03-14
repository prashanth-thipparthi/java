package Array;

public class MaxSumContiguousSubArray {

    public int maxSubArraySum(int[] a){

        int len = a.length;
        int global_max = a[0];
        int local_max = 0;
        int maxElement = a[0];

        int start=0,end=0,temp=0;

        for(int i=0;i<len-1;i++){
            local_max = local_max+a[i];
            if(local_max>global_max){
                global_max = local_max;
                start = temp;
                end = i;
            }

            if(local_max<0){
                local_max = 0;
                temp = i+1;
            }

            if(maxElement < a[i]){
                maxElement = a[i];
            }
        }

        System.out.println("Start Index:"+start+", End Index:"+end);
        return Math.max(global_max,maxElement);
    }

    public static void main (String[] args)
    {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};

       // int a[] = {-10, -10, -10};

        MaxSumContiguousSubArray mscs = new MaxSumContiguousSubArray();
        System.out.println("Maximum contiguous sum is " +
                mscs.maxSubArraySum(a));
    }

}

