package Graph.Dfs;

import java.util.*;

public class CriticalConnections {
        /*
    https://leetcode.com/problems/critical-connections-in-a-network/discuss/451733/ICU-For-Struggling-People-Like-Me-Java-Tarjan-based-solution
    */
    
    public void createAdjacencyMatrix(int n, List<List<Integer>> connections, List<Integer> adjacencyMatrix[]) {
        for(int i=0; i<n; i++) {
            adjacencyMatrix[i] = new LinkedList<>();
        }
        
        for(List<Integer> connection : connections) {
            int vertex1 = connection.get(0);
            int vertex2 = connection.get(1);
            adjacencyMatrix[vertex1].add(vertex2);
            adjacencyMatrix[vertex2].add(vertex1);
        }
    }
    
    public void dfs(int discoveryTime, int previous, int current, boolean[] visited,  int[]lowestReachableNode, List<Integer> adjacencyMatrix[], List<List<Integer>> answers ) {
        
        visited[current] = true;
        lowestReachableNode[current] = discoveryTime;
        
        for(int next : adjacencyMatrix[current]) {
            if(next == previous) {
                continue;
            }
            if(!visited[next]) {
                dfs(discoveryTime+1, current, next, visited, lowestReachableNode, adjacencyMatrix, answers);
            }
            lowestReachableNode[current] = Math.min(lowestReachableNode[current],lowestReachableNode[next]);
            
            
            if(lowestReachableNode[next] >= discoveryTime+1){
                List<Integer> list = new ArrayList<>();
                list.add(current);
                list.add(next);
                answers.add(list);
            }
        }
        
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> answers = new ArrayList<>();
        if(n==0 || connections == null|| connections.size() ==0) {
            return answers;
        }
        
        List<Integer> adjacencyMatrix[] = new LinkedList[n];
        
        createAdjacencyMatrix(n, connections, adjacencyMatrix);
        boolean[] visited = new boolean[n];
        int[] lowestReachableNode = new int[n]; 
        
        dfs(0, -1, 0, visited, lowestReachableNode, adjacencyMatrix, answers);
        return answers;
    }
    
}