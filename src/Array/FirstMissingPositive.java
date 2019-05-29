package Array;

/*
https://leetcode.com/problems/first-missing-positive/

https://leetcode.com/problems/first-missing-positive/discuss/17214/Java-simple-solution-with-documentation
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {



        int len = nums.length;

        /*
        1. Replace the negative numbers as well as the numbers greater than the length of the
        array with some marker constane "n+1"
        */

        for(int i=0; i<len; i++){
            if(nums[i] <= 0 || nums[i] > len){
                nums[i] = len+1;
            }
        }
        /*
        2. Now, all the numbers will be in the range of 1 to "len+1".
           Take every absolute number, reduce it by 1 to get the index and mark the appropriate index as negative. To avoid duplication negation check whether number is negative or not before making it negative
        */

        for(int i=0; i<len; i++){
            int num = Math.abs(nums[i]);

            if(num > len){
                continue;
            }

            num--;

            if(nums[num] > 0){
                nums[num] = -1 * nums[num];
            }
        }

        /*
        3. Next traverse through the array and return the "index+1" value of the first positive number
        */
        for(int i=0; i<len; i++){
            if(nums[i] >= 0){
                return i+1;
            }
        }
        return len+1;
    }
}
