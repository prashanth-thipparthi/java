package TwoPointers;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {       
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int i=0;        
        for(int j=0; j<nums.length; j++) {
            if(j-1 >= 0 && nums[j-1] == nums[j]) {
                continue;
            }
            nums[i++] = nums[j];
        }
        
        return i;
    }
}