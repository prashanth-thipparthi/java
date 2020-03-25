package Array;
import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<List<Integer>>();
        for(int i=0;i<len-2;i++){
            if(i>0 && nums[i-1] == nums[i]){
                continue;
            }
            int reqSum = 0 - nums[i];
            int curSum = 0;
            int  j = i+1; int k = nums.length-1;
            while(j<k){                
                curSum = nums[j] + nums[k];
                if(curSum == reqSum){
                    List<Integer> li = new ArrayList<Integer>();
                    li.add(nums[i]);
                    li.add(nums[j]);
                    li.add(nums[k]);
                    ansList.add(li);                
                    while(j>0 && nums[j] == nums[j+1]){
                        j++;
                    }
                    while(k <len-1 && nums[k] == nums[k+1]){
                        k--;
                    }
                    j++;
                    k--;
                }else if(curSum > reqSum) {
                    k--;
                }else{
                    j++;
                }
            }            
        }
        return ansList;
        
    }
}
