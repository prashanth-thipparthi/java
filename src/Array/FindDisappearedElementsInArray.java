package Array;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array
 */
public class FindDisappearedElementsInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {


        /*
        same as https://leetcode.com/problems/first-missing-positive/

        using the array indices to determine the missing element
        */
        int len = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < len; i++){
            int num = Math.abs(nums[i]);

            num--;

            if(nums[num] >= 0){
                nums[num] = -1 * nums[num];
            }
        }

        for(int i=0; i<len; i++){
            if(nums[i] > 0){
                ans.add(i+1);
            }
        }

        return ans;
    }
}
