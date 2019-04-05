package BackTracking;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    int count=0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        combinationSumUtil(candidates,target,0,result);
        return  result;
    }

    public void combinationSumUtil(int [] candidates,int target, int currentSum, List<List<Integer>> result){
        if(currentSum == target){
            count++;
            return;
        }

        if(currentSum > target)
            return;

        for(int i: candidates){
            combinationSumUtil(candidates,target,currentSum+i,result);
        }
    }

    public static void main(String args[]){

    }
}
