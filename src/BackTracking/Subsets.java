package BackTracking;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/subsets
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length ==0){
            return result;
        }
        int startIndex = 0;
        List<Integer> tempList = new ArrayList<>();

        subsetsUtil(nums,result,tempList,startIndex);
        return result;
    }

    public void subsetsUtil(int [] nums, List<List<Integer>> result,List<Integer> tempList,int startIndex){
        result.add(new ArrayList<>(tempList));
        if(tempList.size() == nums.length){
            return;
        }

        for(int i = startIndex;i<nums.length;i++){
            tempList.add(nums[i]);
            subsetsUtil(nums,result,tempList,i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String args[]){
        Subsets s = new Subsets();
        int [] nums = {1,2,3};
        List<List<Integer>> sets =  s.subsets(nums);
        for(List<Integer> subset : sets){
            System.out.println(subset);
        }
    }
}
