package Array;

/*https://leetcode.com/problems/find-pivot-index/*/

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {

        long sum = 0;

        for(int num : nums)
            sum += num;

        long prefixSum = 0;
        for(int i=0; i<nums.length; i++){
            if(prefixSum*2 == sum-nums[i]){
                return i;
            }
            prefixSum += nums[i];
        }
        return -1;
    }

    /*
        public int pivotIndex(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }

        int forward[] = new int[len+2];
        forward[0] = 0;
        forward[1] = nums[0];
        for(int i=2; i<len+1;i++){
            forward[i] = forward[i-1] + nums[i-1];
        }
        forward[len+1] = 0;

        // for(int i=0; i<len+2;i++){
        // System.out.println(forward[i]);
        // }


        int backward[] = new int[len+2];
        backward[len+1] = 0;
        backward[len] = nums[len-1];
        for(int j=len-1; j>0; j--){
            backward[j] = nums[j-1] + backward[j+1];
        }
        backward[0] = 0;

        // for(int i=0; i<len+2;i++){
        // System.out.println(backward[i]);
        // }
        for(int i=1; i<len-2;i++){
            if(forward[i-1] == backward[i+1])
                return i-1;
        }

        return -1;
    }
     */
    public static void main(String args[]){

    }
}
