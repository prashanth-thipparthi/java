package Graph.Dfs;
import java.util.*;

public class BFS_DFS_Template {
    int no_vertices;
    List<Integer> adjVertices[] = null;

    public BFS_DFS_Template(int vertices){
        this.no_vertices = vertices;
        adjVertices = new ArrayList[vertices];
        for(int i=0; i<no_vertices; i++) {
            adjVertices[i] = new ArrayList<>();
        }
    }

    public void addEdge(int from, int to){
        this.adjVertices[from].add(to);
    }

    public void DFS_Util(int node, boolean[] visited)   {
        if(visited[node]){
            return;
        }
        visited[node] = true;
        Iterator<Integer> itr = this.adjVertices[node].iterator();

        while(itr.hasNext()){
            int i = itr.next();            
            if(!visited[i]){
                System.out.println(i + " ");
                DFS_Util(i,visited);
            }
        }
        return;
    }

    public void DFS(int node)   {
        int vertices = this.no_vertices;
        boolean[] visited = new boolean[vertices];
        for(int i=0; i<vertices; i++) {
            if(!visited[i]){
                DFS_Util(2,visited);
            }
        }
    }

    public void BFS(int node, boolean[] visited) {
        Queue<Integer> bfs = new LinkedList<>();
        bfs.offer(node);

        while(bfs.size() > 0) {
            int level_size = bfs.size();
            for(int i=0; i<level_size; i++) {
                int level_node = bfs.poll();
                Iterator<Integer> itr = this.adjVertices[level_node].iterator();
                while(itr.hasNext()) {
                    int internal_level_node = itr.next();
                    if(!visited[internal_level_node]) {
                        System.out.println(internal_level_node);
                        visited[internal_level_node] = true;
                        bfs.offer(internal_level_node);
                    }
                }
            }
        }
    }
    public static void main(String args[]) 
    { 
        BFS_DFS_Template g = new BFS_DFS_Template(11); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(0, 5); 
        g.addEdge(1, 6); 
        g.addEdge(2, 7);
        g.addEdge(3, 8); 
        g.addEdge(4, 9); 
        g.addEdge(5, 10);
  
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        //g.DFS(2);

        /**/
        boolean[] visited = new boolean[11];
        
        g.BFS(0,visited); 
    } 
} 