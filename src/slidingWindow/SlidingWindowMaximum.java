package slidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len == 0 || k==1) {
            return nums;
        }   
        
        int[] res = new int[len-k+1];
        int ri = 0;
        Deque<Integer> deq = new ArrayDeque<Integer>();
        
        for(int j=0; j<len; j++) {
            /*remove the elements from front if elements are not in the sliding window */
            while(!deq.isEmpty() && deq.peek() < j-k+1 ) {
                deq.poll();
            } 
            
            /*pop elements less than the current element as we have the maximum element in the window*/
            while(!deq.isEmpty() && nums[deq.peekLast()] < nums[j]) {
                deq.pollLast();
            }
            
            deq.offer(j);
            if(j > k-2) {
                res[ri++] = nums[deq.peek()];
            }
        }
        return res;
    }

    public static void main(String args[]){
        SlidingWindowMaximum swm = new SlidingWindowMaximum();
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int ans [] = swm.maxSlidingWindow(arr,k);

        for(int a: ans){
            System.out.println(a);
        }

    }
}
