package slidingWindow;
import java.util.Map;
import java.util.HashMap;

public class TotalFruit {
    public int totalFruit(int[] tree) {
        int i=0, j=0;
        int len = tree.length;
        Map<Integer, Integer> hmap = new HashMap<>();
        int count = 2;
        int maxFruits = Integer.MIN_VALUE;
        while(j < len) {
            if(!hmap.containsKey(tree[j])) {
                count --;
            }
            hmap.put(tree[j], j);
            while(count < 0) {
                i = hmap.get(tree[i]);
                count++;
            }
            j++;
            maxFruits = Math.max(maxFruits, j-i);
        }
        
        return maxFruits == Integer.MIN_VALUE ? 0 : maxFruits;
    }
}