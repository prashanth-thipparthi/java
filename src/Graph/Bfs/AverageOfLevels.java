package Graph.Bfs;
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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);
        long levelSum = 0;
        int levelCount = 0;
        List<Double> answer = new ArrayList<>();
        
        while(bfs.size() > 0){
            int size = bfs.size();
            levelSum = 0;
            levelCount = 0;
            for(int i=0; i<size; i++) {
                TreeNode node = bfs.poll();
                levelSum += node.val;
                levelCount += 1;
                
                if(node.left != null){
                    bfs.offer(node.left);
                }                
                if(node.right != null){
                    bfs.offer(node.right);
                }
            }
            answer.add((double)levelSum/levelCount);
        }
        return answer;
    }
}