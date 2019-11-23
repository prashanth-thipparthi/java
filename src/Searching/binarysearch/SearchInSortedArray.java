package Searching.binarysearch;

/*
https://leetcode.com/problems/search-in-rotated-sorted-array/
*/

import java.util.*;

public class SearchInSortedArray {
    /*
    1. Find the index of smallest element in the sorted rotated array.
    2. Smallest element index value is equal to the number of rotations the array has undergone.
    3. Next while performing the binary search, adjust the middle element index according to the rotation and return it.
    */ 

    public int findSmallestIndexInRotatedSortedArray(int[] shiftArr, int low, int high) {
        if(low == high) {
            return low;
        }else if(low < high) {
            int mid = (low + (high-low)/2);
            if(shiftArr[mid] < shiftArr[high]) {
                return findSmallestIndexInRotatedSortedArray(shiftArr, low, mid);
            }else{
                return findSmallestIndexInRotatedSortedArray(shiftArr, mid+1, high);
            }
        }
        return low;
    }

    public int search(int[] shiftArr, int num) {
        int rot = findSmallestIndexInRotatedSortedArray(shiftArr, 0, shiftArr.length-1);

        int low = 0;
        int high = shiftArr.length-1;

        while(low <= high) {
            int mid = (low + (high-low)/2);
            int rotatedMid = (mid + rot)%shiftArr.length ;
            if(shiftArr[rotatedMid] == num) {
                return rotatedMid;
            }else if(shiftArr[rotatedMid] < num) {
                low = mid+1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int nums[] = new int[]{4,5,6,7,0,1,2};
        SearchInSortedArray sisa = new SearchInSortedArray();
        System.out.println("index:"+sisa.search(nums, 0));
    }

}


