package Graph;

import java.util.*;

public class GraphTraversal {

    public void DFS(Graph<Integer> graph){
        Set<Long> visited = new HashSet<>();
        for(Vertex<Integer> v:graph.getAllVertex()){
            if(!visited.contains(v.getId())){
                DFSUtil(v,visited);
            }

        }
    }

    public void DFSUtil(Vertex<Integer> v, Set<Long> visited){
        visited.add(v.getId());
        System.out.print(v.getId()+" ");
        for(Vertex<Integer> adjvertex : v.getAdjacentVertexes()){
            if(!visited.contains(adjvertex.getId())){
                DFSUtil(adjvertex,visited);
            }
        }
    }

    public void BFS(Graph<Integer> graph){
        Set<Long> visited = new HashSet<>();
        Queue<Vertex<Integer>> queue = new LinkedList<Vertex<Integer>>();

        for(Vertex<Integer> vertex : graph.getAllVertex()){
            if(!visited.contains(vertex.getId())){
                visited.add(vertex.getId());
                queue.add(vertex);
                while(queue.size()!=0){
                    Vertex<Integer> vq = queue.poll();
                    System.out.println(vq.getId()+" ");
                    for(Vertex<Integer> v : vq.getAdjacentVertexes()){
                        if(!visited.contains(v.getId())){
                            queue.add(v);
                            visited.add(v.getId());
                        }
                    }
                }
            }
        }
    }

    public static void main(String args[]){
        Graph<Integer> graph = new Graph<Integer>(true);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(3,4);
        graph.addEdge(4,6);
        graph.addEdge(6,5);
        //graph.addEdge(5,1);
        graph.addEdge(5,3);

        GraphTraversal g = new GraphTraversal();
        g.BFS(graph);
    }
}
