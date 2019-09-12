package Stack.MonotonicIncrDecrStack;


import java.util.Stack;

/*
https://leetcode.com/problems/sum-of-subarray-minimums/discuss/178876/stack-solution-with-very-detailed-explanation-step-by-step
 */
public class MonotonicIncreasingStack {

    /*
    What is monotonous increase stack?
    Roughly speaking, the elements in the an monotonous increase stack keeps an increasing order.
    */

    public void monotonicIncreasingStackTemplate(int[] A){
        Stack<Integer> in_stack = new Stack<Integer>();

        for(int i=0; i < A.length; i++){
            while(!in_stack.empty() && in_stack.peek() > A[i]){
                in_stack.pop();
            }
            in_stack.push(A[i]);
        }
    }

    /*
    We can find the "next less element" and "previous less element" using the monotonous increasing stack
    */

    public int[] nextLessElement(int[] A){

        Stack<Integer> in_stack = new Stack<>();
        int[] nextLessElement = new int[A.length];

        for(int i=0; i < A.length; i++){
            while(!in_stack.empty() && A[in_stack.peek()] > A[i]){
                nextLessElement[in_stack.peek()] = i;
                in_stack.pop();
            }
            in_stack.push(i);
        }
        return nextLessElement;
    }

    public int[] previousLessElement(int[] A){
        Stack<Integer> in_stack = new Stack<>();
        int[] previousLessElement = new int[A.length];

        for(int i=0; i<A.length; i++){
            while(!in_stack.empty() && A[in_stack.peek()] > A[i]){
                in_stack.pop();
            }
            previousLessElement[i] = in_stack.empty() ? -1 : in_stack.peek();
            in_stack.push(i);
        }
        return  previousLessElement;
    }

    public static void main(String args[]){
        MonotonicIncreasingStack mis = new MonotonicIncreasingStack();
        int arr[] = {2,9,7,8,3,4,6,1};
        int nextLess[] = mis.nextLessElement(arr);

        for(int num : nextLess){
            System.out.print(num+" ");
        }
    }
}
