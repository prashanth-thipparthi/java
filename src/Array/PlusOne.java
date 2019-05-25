package Array;

/* https://leetcode.com/problems/plus-one/ */

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits == null)
            return new int[]{};
        int len = digits.length;
        int i = len -1;
        int carry = 1;
        int number;

        while(i >= 0){
            number = digits[i] + carry;
            digits[i] = number%10;
            carry = number/10;
            i--;
        }

        if(i == -1 && carry > 0){
            int new_digits[] = new int[len+1];
            new_digits[0] = carry;
            for(int j=1; j<len+1; j++){
                new_digits[j] = digits[j-1];
            }
            return new_digits;
        }

        return digits;
    }
}
