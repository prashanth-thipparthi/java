package Array;

import java.util.Arrays;
import java.util.HashMap;

/*
leet code - Two Sum
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        //int [] ret = new int[2];

        Arrays.sort(nums);

        int l=0,h=nums.length-1;

        while(l<h){
            if(nums[l]+nums[h]==target){
                return new int[] {l,h};
            }
            if(nums[l]+nums[h] > target){
                h--;
            }else{
                l++;
            }
        }
        return new int[]{};
    }

    public int[] twoSumTwoPassHash(int[] nums,int target){

        HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],i);
        }

        for(int i=0;i< nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                return new int[]{i,hm.get(target-nums[i])};
            }
        }
        return new int[]{};
    }

    public int[] twoSumOnePassHash(int[] nums,int target){
        HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();

        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(target-nums[i])){
                return new int[]{i,hm.get(target-nums[i])};
            }else{
                hm.put(nums[i],i);
            }
        }
        return new int[]{};
    }

    public static void main (String[] args)
    {
        int A[] = {1, 4, 45, 6, 10, 8};
        int n = 16;
        TwoSum t = new TwoSum();

        // After Sort , A = {1,4,6,8,10,45}
        //int ret[] = t.twoSum(A,n);
        //int ret[] = t.twoSumTwoPassHash(A,n);
        int ret[] = t.twoSumOnePassHash(A,n);
        for(int i=0;i<ret.length;i++){
            System.out.println(ret[i]);
        }
    }

}
