package Stack.MonotonicIncrDecrStack;

import java.util.Stack;

public class SumOfSubArrayMinimums {
    /*
    https://leetcode.com/problems/sum-of-subarray-minimums/

    https://leetcode.com/problems/sum-of-subarray-minimums/discuss/178876/stack-solution-with-very-detailed-explanation-step-by-step
     */

    public int sumSubarrayMins(int[] A) {


        Stack<Integer> in_stack = new Stack<Integer>();

        int len = A.length;
        int[] left = new int[len];
        int[] right = new int[len];

        for(int i=0; i<len; i++){
            left[i] = i+1;
            right[i] = len-i;
        }

        /* number of sub-arrays on left part of the element
           i.e (index(i) - previousLessElement)
        */
        for(int i=0; i<len; i++){
            // use ">=" to deal with duplicate elements
            while(!in_stack.empty() && A[in_stack.peek()] > A[i]){
                in_stack.pop();
            }
            left[i] = in_stack.empty() ? i+1 : i - in_stack.peek();
            in_stack.push(i);
        }

        /* number of sub-arrays on the right side of the element
           i.e (nextLessElement - index,i)
        */
        in_stack = new Stack();
        for(int i=0; i < len; i++){
            // use ">=" to deal with duplicate elements
            while(!in_stack.empty() && A[in_stack.peek()] > A[i]){
                right[in_stack.peek()] = i - in_stack.peek();
                in_stack.pop();
            }
            in_stack.push(i);
        }

        int ans = 0;
        int mod = (int)1e9 + 7;
        for(int i=0; i<len; i++){
            ans = ( ans + A[i] * left[i] * right[i] ) % mod;
        }

        return ans;
    }
}
