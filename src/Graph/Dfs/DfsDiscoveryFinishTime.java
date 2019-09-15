package Graph.Dfs;

import java.util.ArrayList;
import java.util.List;

public class DfsDiscoveryFinishTime {

    private int V;
    private final List<List<Integer>> adj;
    private boolean[] visited;
    int dis_time[];
    int fin_time[];
    int clock = 0;

    DfsDiscoveryFinishTime(int noVertices){
        V = noVertices;
        adj = new ArrayList<>();

        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        visited = new boolean[V];
        dis_time = new int[V];
        fin_time = new int[V];
    }

    public void addEdge(int source, int dest){
        adj.get(source).add(dest);
    }

    public void dfs_util(int i) {
        visited[i] = true;
        dis_time[i] = clock;
        clock += 1;
        for(int node : adj.get(i)){
            if(visited[node] == false){
                dfs_util(node);
            }
        }
        fin_time[i] = clock;
        clock += 1;
    }

    public void dfs(int source){
        for(int i = source; i<V;i++  ){
            if(visited[i] == false)
                dfs_util(i);
        }
    }

    public static void main(String args[]){
        int noVertices = 6;
        DfsDiscoveryFinishTime dfs = new DfsDiscoveryFinishTime(noVertices);
        dfs.addEdge(0,3);
        dfs.addEdge(3,2);
        dfs.addEdge(3,4);
        dfs.addEdge(4,5);
        dfs.addEdge(3,5);
        dfs.addEdge(2,0);
        dfs.addEdge(1,2);
        dfs.addEdge(1,0);

        //System.out.println(-1%4);

        dfs.dfs(0);

        System.out.println("Start and end times of Nodes:");

        for(int i=0; i<noVertices; i++){
            System.out.println("Node:"+i+", Start:"+dfs.dis_time[i]+", End time:"+dfs.fin_time[i]);
        }
    }
}
