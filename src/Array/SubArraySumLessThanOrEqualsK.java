package Array;

import java.util.HashMap;
import java.util.Map;
/*
https://www.geeksforgeeks.org/longest-subarray-sum-elements-atmost-k/
*/

public class SubArraySumLessThanOrEqualsK {

    int atMostSum(int arr[], int n, int k) 
    { 
        int sum = 0; 
        int cnt = 0, maxcnt = 0; 
    
        for (int i = 0; i < n; i++) { 
            
            // If adding current element doesn't 
            // cross limit add it to current window 
            if ((sum + arr[i]) <= k) { 
                sum += arr[i];  
                cnt++; 
            }  
    
            // Else, remove first element of current 
            // window and add the current element 
            else if(sum!=0) 
            { 
                sum = sum - arr[i - cnt] + arr[i]; 
            } 
    
            // keep track of max length. 
            maxcnt = max(cnt, maxcnt);  
        } 
        return maxcnt; 
    } 
}