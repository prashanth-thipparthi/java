package Array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int sum = 0;
        Map<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        hmap.put(0,1);
        int result = 0;
        
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            
            if(hmap.containsKey(sum-k)) {
                result += hmap.get(sum-k);
            }
            hmap.put(sum,hmap.getOrDefault(sum,0)+1);
        }
        
        return result;
    }
}