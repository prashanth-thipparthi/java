package Graph.Dfs;
import java.util.*;

public class CriticalRouters {

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

    public void dfs(int discoveryTime, int previous, int current, boolean[] visited,  int[]lowestReachableNode, List<Integer> adjacencyMatrix[], List<Integer> answers ) {
        
        visited[current] = true;
        lowestReachableNode[current] = discoveryTime;
        int children =0;
        
        for(int next : adjacencyMatrix[current]) {
            if(!visited[next]) {
                children++;        
                dfs(discoveryTime+1, current, next, visited, lowestReachableNode, adjacencyMatrix, answers);                
                lowestReachableNode[current] = Math.min(lowestReachableNode[current],lowestReachableNode[next]);
                
                if((previous == -1 && children > 1) || ( previous != -1 && lowestReachableNode[next] >= discoveryTime)){
                    answers.add(current);
                }
            }else if(next != previous){
                lowestReachableNode[current] = Math.min(lowestReachableNode[current],lowestReachableNode[next]);
            }
        }
        
    }
    

    public List<Integer> criticalNodes(int n, List<List<Integer>> connections) {
        List<Integer> answers = new ArrayList<>();
        if(n==0 || connections == null|| connections.size() ==0) {
            return answers;
        }
        
        List<Integer> adjacencyMatrix[] = new LinkedList[n];
        
        createAdjacencyMatrix(n, connections, adjacencyMatrix);
        boolean[] visited = new boolean[n];
        int[] lowestReachableNode = new int[n]; 
        for(int i=0;i<n;i++) {
            if(!visited[i])
                dfs(0, -1, 2, visited, lowestReachableNode, adjacencyMatrix, answers);
        }
        return answers;
    }

    public static void main(String args[]) {
        CriticalRouters cr = new CriticalRouters();
        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(0);        l1.add(1);         connections.add(l1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(0);        l2.add(2);         connections.add(l2);
        List<Integer> l3 = new ArrayList<>();
        l3.add(1);        l3.add(3);         connections.add(l3);
        List<Integer> l4 = new ArrayList<>();
        l4.add(2);        l4.add(3);         connections.add(l4);
        List<Integer> l5 = new ArrayList<>();
        l5.add(2);        l5.add(5);         connections.add(l5);
        List<Integer> l6 = new ArrayList<>();
        l6.add(5);        l6.add(6);         connections.add(l6);
        List<Integer> l7 = new ArrayList<>();
        l7.add(3);        l7.add(4);         connections.add(l7);

        System.out.println(cr.criticalNodes(7, connections));
    }
}