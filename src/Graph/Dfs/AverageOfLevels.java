package Graph.Dfs;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

public class AverageOfLevels {
    public void averageOfLevels_utils(TreeNode root, int i, List<Double> sum, List<Integer> count) {
        if(root == null){
            return;
        }
        
        if(sum.size() >= i+1){
            sum.set(i,sum.get(i)+root.val);
            count.set(i,count.get(i)+1);
        }else{
            sum.add((double)root.val);
            count.add(1);
        }
        averageOfLevels_utils(root.left, i+1, sum, count);
        averageOfLevels_utils(root.right, i+1, sum, count);
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> sum = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        List<Double> ans = new ArrayList<>();
        
        averageOfLevels_utils(root, 0, sum, count);
        int levels = sum.size();
        
        for(int i=0; i<levels; i++) {
            ans.add((double)sum.get(i)/count.get(i));
        }
        return ans;
    }
}