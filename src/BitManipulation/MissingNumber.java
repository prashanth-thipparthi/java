package BitManipulation;

/*
https://leetcode.com/problems/missing-number

https://leetcode.com/problems/missing-number/discuss/69791/4-Line-Simple-Java-Bit-Manipulate-Solution-with-Explaination

https://leetcode.com/problems/single-number-ii/discuss/43295/Detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {

        /*
        if(nums.length == 1){
            return 1;
        }*/
        int xor = 0;
        for(int i = 1; i<nums.length+1; i++){
            xor = i ^ xor ^ nums[i-1];
        }
        return xor;
    }
}
