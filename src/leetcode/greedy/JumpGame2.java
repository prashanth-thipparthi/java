package leetcode.greedy;

/* https://leetcode.com/problems/jump-game-ii *

https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy/
 */
public class JumpGame2 {
    public int jump(int[] nums) {
        int len = nums.length;
        int curBegin = 0;
        int curEnd = 0;
        int farthestEnd = 0;
        int jump = 0;
        for(int i=0; i< len-1; i++){
            farthestEnd = Math.max(farthestEnd,i+nums[i]);
            if(i == curEnd){
                jump++;
                curEnd = farthestEnd;

                if( curEnd >= len-1){
                    break;
                }
            }
        }
        return jump;
    }
}
