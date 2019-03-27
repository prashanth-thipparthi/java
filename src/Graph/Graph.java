package Graph;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {


}

class Vertex<T>{
    long id;
    private T data;
    private List<Edge<T>> edges = new ArrayList();
    private List<Vertex<T>> adjacentVertex = new ArrayList<>();

    Vertex(long id){
        this.id = id;
    }

    public long getID(){
        return id;
    }

    public void setData(T data){
        this.data = data;
    }

    public T getData(){
        return data;
    }


}

class Edge<T>{

    private boolean isDirected = false;
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    private int weight;

    Edge(Vertex<T> vertex1, Vertex<T> vertex2){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean isDirected,int weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        this.isDirected = isDirected;
    }

    Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.isDirected = isDirected;
    }

    Vertex<T> getVertex1(){
        return vertex1;
    }

    Vertex<T> getVertex2(){
        return vertex2;
    }

    boolean isDirected(){
        return this.isDirected;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}