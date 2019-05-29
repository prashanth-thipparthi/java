package DynamicProgramming;

/* https://leetcode.com/articles/jump-game/ */
public class JumpGame {
    boolean c_j[] = null;
    public boolean canJump(int[] nums) {
        /*
        if(canJump(nums,0)){
            return true;
        }else{
            return false;
        }*/
        c_j = new boolean[nums.length];

        for(int i = nums.length-1; i >= 0; i--){
            c_j[i] = canJump(nums, i);
        }
        return c_j[0];
    }

    public boolean canJump(int[] nums, int index) {
        if(index > nums.length-1)
            return false;

        if(index == nums.length-1)
            return true;


        int index_copy = nums[index];

        while(index_copy > 0){
            if( index + index_copy > nums.length-1){
                index_copy--;
                continue;
            } else if(c_j[index + index_copy]){
                return true;
            }else{
                index_copy--;
            }
        }
        return false;
    }

    public static void main(String args[]){
        JumpGame jg = new JumpGame();
        int nums[] = {3,2,1,0,4};
        //int nums[] = {3,2,1,0,4};
        //jg.canJump();
    }
}
