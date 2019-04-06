package Searching;

public class QuickSelect {

    /*
    https://leetcode.com/problems/kth-largest-element-in-an-array/
     */

    public int partition(int []nums, int low, int high){

        int i = low-1;
        int j = low;
        int pivot = nums[high];
        while(j<high){
            if(nums[j]<pivot){
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }else{
                j++;
            }
        }

        int temp = nums[high];
        nums[high] = nums[i+1];
        nums[i+1] = temp;

        return i+1;
    }

    public int quickSelect(int[] nums, int low, int high, int target){
        if(high>low){
            int pivot = partition(nums, low, high);
            if(pivot == target){
                return nums[pivot];
            }else if(pivot < target){
                return quickSelect(nums,pivot+1,high,target);
            }else{
                return quickSelect(nums,low,pivot-1,target);
            }
        }
        return -1;
    }

    public int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length-1;
        return quickSelect(nums,low,high,(nums.length-k));
    }

    public static void main(String args[]){
        QuickSelect qs = new QuickSelect();
        int [] nums = {3,2,1,5,6,4};
        int k = 2;
        int kthelement = qs.findKthLargest(nums,k);
        System.out.println("kthelement:"+kthelement);
    }
}
