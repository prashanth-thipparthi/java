package TopologicalSort;
import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        /*
        https://leetcode.com/problems/course-schedule-ii/solution/
        
        The solution basically refers to the above pattern. We are finding the back edge or the cycle in the graph. If we are finding the cycle then we return an empty array signifying we cannot have the topological sort. 
        In the other case, We initially assign every node eith white color, when we visit the node we change the color to 'gray' and traverse in the dfs order. In the traversal if we find a adjacent node color as grey then we can declare that there is a cycle.
        At the end we change the node color to 'Black' and add it to stack.
        */
        
        /*
        color variable to be in sync with explanation
        WHITE - 1
        GREY - 2
        BLACK - 3
        */
        if(numCourses == 0) {
            return new int[]{};
        }
        int[] result = new int[numCourses];
        
        List<Integer> adjMatrix[] = new LinkedList[numCourses];
        Map<Integer, Integer> colorMap = new HashMap<>();
        boolean isCyclic = false;
        for(int i=0; i<numCourses; i++) {
            adjMatrix[i] = new LinkedList<>();
            colorMap.put(i,1);
        }        
        
        for(int[] course : prerequisites) {
            int preReq = course[1];
            int cour =  course[0];
            adjMatrix[preReq].add(cour);
        }
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<numCourses; i++) {
            if(colorMap.get(i) == 1 && dfs(adjMatrix, stack, colorMap, i) == true){
                   return new int[]{};
            }
        }
        
        int i=0;         
        while(!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }
    
    boolean dfs(List<Integer> adjMatrix[], Stack<Integer> stack,  Map<Integer, Integer> colorMap, int i) {
        if(colorMap.get(i) == 3) {
            return false;
        }
        colorMap.put(i, 2);
        
        for(Integer node : adjMatrix[i]) {
            if(colorMap.get(node) == 1 ){
                if (dfs(adjMatrix, stack, colorMap, node) == true){
                  return true;  
                }
            }else if(colorMap.get(node) == 2){
                return true;
            }
        }
        
        colorMap.put(i, 3);
        stack.add(i);
        return false;
    }
}