package Array;

public class MinimumSizeSubArraySum {
/*
https://leetcode.com/problems/minimum-size-subarray-sum/
 */

    public int minSubArrayLen(int s, int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int sum = 0;
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;

        while(end < n){
            sum += nums[end++];

            while(sum >= s){
                min = Math.min(min, end-start);
                sum -= nums[start++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;

    }

}
