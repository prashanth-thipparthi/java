package Graph;

import java.util.*;

public class GraphTraversal {

    public void BFS(Graph<Integer> graph){
        Set<Long> visited = new HashSet<>();
        Queue<Vertex<Integer>> queue = new LinkedList<Vertex<Integer>>();

        for(Vertex<Integer> vertex : graph.getAllVertex()){
            if(!visited.contains(vertex.getId())){
                visited.add(vertex.getId());
                queue.add(vertex);

                while(queue.size()>0){
                    Vertex<Integer> v = queue.poll();
                    if(!visited.contains(v.getId())){

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


    }
}
