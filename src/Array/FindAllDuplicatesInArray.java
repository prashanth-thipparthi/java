package Array;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/find-all-duplicates-in-an-array
 */
public class FindAllDuplicatesInArray {

    public List<Integer> findDuplicates(int[] nums) {

        /*
        same as https://leetcode.com/problems/first-missing-positive/

        using the array indices to determine the missing element
        */
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<len; i++){
            int num = Math.abs(nums[i]);
            num--;

            if(nums[num] < 0){
                ans.add(num+1);
            }else{
                nums[num] = -1 * nums[num];
            }
        }

        return ans;
    }
}
