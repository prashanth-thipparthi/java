package Array;
import java.util.*;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        int result = nums[0] + nums[1] + nums[len-1];
        Arrays.sort(nums);
        for(int i=0; i<len-2;i++){
            int j = i+1; int k = len-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < target){
                    j++;
                }else{
                    k--;
                }       
                if(Math.abs(sum - target) < Math.abs(result - target)){
                    result = sum;   
                }
            }
        }        
        return result;
    }
}