package Array;

/* https://leetcode.com/problems/largest-number-at-least-twice-of-others/ */

public class LargestNumberTwiceOfOthers {

    public int dominantIndex(int[] nums) {

        if(nums == null )
            return -1;
        int len = nums.length;
        if(len == 1)
            return 0;
        int max = Integer.MIN_VALUE;
        int second_max = Integer.MIN_VALUE;
        int max_index = 0;
        for(int i=0; i<len; i++){
            if(nums[i] > max){
                second_max  = max;
                max = nums[i];
                max_index = i;
            }else if(nums[i] > second_max){
                second_max = nums[i];
            }
        }

        if(second_max * 2 <= max){
            return max_index;
        }else{
            return -1;
        }
    }
}
