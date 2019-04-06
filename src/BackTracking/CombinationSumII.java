package BackTracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum/
 */

public class CombinationSumII {

    public List<List<Integer>> combinationSumII(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> tempList = new ArrayList<>();
        int startIndex = 0;
        combinationSumIIUtil(candidates,target,result,tempList,startIndex);
        return  result;
    }

    public void combinationSumIIUtil(int [] candidates,int target,List<List<Integer>> result,List<Integer> tempList
            ,int startIndex){
        if(target == 0){
            result.add(new ArrayList<>(tempList));
            return;
        }else if(target<0){
            return;
        }else{
            for(int i=startIndex;i<candidates.length;i++){

                if(i > startIndex &&candidates[i]==candidates[i-1]){
                    continue;
                }
                if(candidates[i]>target){
                    break;
                }
                tempList.add(candidates[i]);
//                if(target < 0){
//                    continue;
//                }
                combinationSumIIUtil(candidates,target-candidates[i],result,tempList,i+1);// If numbers are not repeating we start from next number i.e i+1
                tempList.remove(tempList.size()-1);
            }
        }
    }

//    public List<List<Integer>> combinationSumII(int[] nums, int target) {
//        List<List<Integer>> list = new ArrayList<>();
//        Arrays.sort(nums);
//        backtrack(list, new ArrayList<>(), nums, target, 0);
//        return list;
//    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static void main(String args[]){
        int[] candidates = {2,3,6,7};
        int target = 7;

        CombinationSumII cs = new CombinationSumII();
        List<List<Integer>> combinations = cs.combinationSumII(candidates,target);
        for(List<Integer> combination:combinations){
            System.out.println(combination);
        }
    }
}

