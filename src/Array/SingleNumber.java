package Array;

public class SingleNumber {

    public int singleNumber2(int[] nums) {
        int x1 = 0, x2 = 0, mask = 0;

        for (int i : nums) {
            x2 ^= x1 & i;
            x1 ^= i;
            mask = ~(x1 & x2);
            x2 &= mask;
            x1 &= mask;
        }

        return x1;  // Since p = 1, in binary form p = '01', then p1 = 1, so we should return x1.
        // If p = 2, in binary form p = '10', then p2 = 1, and we should return x2.
        // Or alternatively we can simply return (x1 | x2).
    }

    public int singleNumber3(int[] nums) {
        int x1 = 0, x2 = 0, x3  = 0, mask = 0;

        for (int i : nums) {
            x3 ^= x2 & x1 & i;
            x2 ^= x1 & i;
            x1 ^= i;
            mask = ~(x1 & ~x2 & x3);
            x3 &= mask;
            x2 &= mask;
            x1 &= mask;
        }

        return x1;  // Since p = 3, in binary form p = '011', then p1 = p2 = 1, so we can return either x1 or x2.
        // If p = 4, in binary form p = '100', only p3 = 1, which implies we can only return x3.
        // Or alternatively we can simply return (x1 | x2 | x3).
    }

    public static void main(String args[]){
        //int nums[] = {0,1,0,1,0,1,99};
        //int nums[] = {2,2,3,2};
        SingleNumber sn = new SingleNumber();
        //System.out.println("no: "+sn.singleNumber2(nums));

        int nums[] = {2,4,2,4,2,4,2,2,4,4,3};
        System.out.println("no: "+sn.singleNumber3(nums));
    }
}
