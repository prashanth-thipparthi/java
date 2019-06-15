package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/subarrays-with-k-different-integers/
https://leetcode.com/problems/subarrays-with-k-different-integers/discuss/234482/JavaC%2B%2BPython-Sliding-Window-with-Video

Question: Can anyone please explain why we took a approach like f(exactly K) = f(atMost K) - f(atMost K-1) in this question, instead of just iterating once over the array with l and r
and finding the answer(the standard approach that we have been taking for all two pointers problem).

Answer: I am afraid that we can get the 2,1 if apply standard two pointer on the example: [1,2,1,2,3], when i = 0, j = 2 we run result += j - i + 1; and j - i + 1 is 3 because it contains 3 cases: 121, 21, 1, which contains the case 2, 1 that you specify. In fact, the real reason we cannot use standard approach here is that, standard approach is counting atMostK instead of exactlyK

 */

public class SubArraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] A, int K) {

        return atMostK(A, K) - atMostK(A, K-1);
    }

    public int atMostK(int[] A, int K){
        int start = 0, end = 0, counter = 0, arrays = 0;
        Map<Integer,Integer> distinct = new HashMap<Integer,Integer>();
        int res = 0;
        while(end < A.length){
            int a1 = A[end];
            if(distinct.getOrDefault(a1,0) == 0)
                K--;
            distinct.put(a1,distinct.getOrDefault(a1,0)+1);
            end++;
            while(K < 0){
                int a2 = A[start];
                distinct.put(a2,distinct.getOrDefault(a2,0)-1);
                if(distinct.getOrDefault(a2,0) == 0)
                    K++;
                start++;
            }
            res += end-start+1;
        }
        return res;
    }

    public static void main(String args[]){

        SubArraysWithKDifferentIntegers sub = new SubArraysWithKDifferentIntegers();
        int res = sub.subarraysWithKDistinct(new int[]{1,2,1,2,3},2);
        System.out.println("result: "+res);
    }
}
