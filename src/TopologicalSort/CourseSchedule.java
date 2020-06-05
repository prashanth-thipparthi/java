package TopologicalSort;

import java.util.*;
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> adjMatrix[] = new LinkedList[numCourses];
        Map<Integer, Integer> colorMap = new HashMap<>();
        /*
        WHITE - 1;
        GREY - 2;
        BLACK - 3;
        */        
        for(int i=0; i<numCourses; i++) {
            adjMatrix[i] = new LinkedList<>();
            colorMap.put(i,1);
        }
        
        for(int[] course : prerequisites) {
            int preReq = course[1];
            int cour = course[0];            
            adjMatrix[preReq].add(cour);
        }
        
        for(int i=0; i<numCourses; i++) {
            if(colorMap.get(i) == 1 && dfs_isCyclic(adjMatrix, colorMap, i) == true) {
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs_isCyclic(List<Integer> adjMatrix[],  Map<Integer, Integer> colorMap, int i) {
        if(colorMap.get(i) == 3) {
            return false;
        }   
        
        colorMap.put(i,2);
        
        for(Integer node : adjMatrix[i]) {
            if(colorMap.get(node) == 1) {
                if(dfs_isCyclic(adjMatrix, colorMap, node) == true) {
                    return true;
                }
            }else if(colorMap.get(node) == 2) {
                return true;
            }
        }
        
        colorMap.put(i,3);
        return false;
    }
}