package Test;

public class Test {

//    public static void main(String args[]){

//        int a[][] = new int[2][2];
//
//        a[1][1] = 5;
//
//        String s = "hdjsf237@2$%^&(";
//
//        char ar[] = s.toCharArray();
//
//        for(int i=0;i<ar.length;i++){
//            System.out.println((int)ar[i]);
//        }
//        for(int i=0;i<2;i++){
//            for(int j=0;j<2;j++){
//                System.out.println(a[i][j]);
//            }
//
//        }
//    }

    public static int maxSubArraySum(int a[]){

        int global_max = a[0];
        int local_max = 0;

        for(int i=1;i<a.length;i++){
            local_max = Math.max(local_max+a[i],a[i]);

            if(local_max > global_max){
                global_max = local_max;
            }
            if(local_max<0){
                local_max = 0;
            }
        }
        return global_max;
    }

    public static void main (String[] args)
    {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));
    }
}
