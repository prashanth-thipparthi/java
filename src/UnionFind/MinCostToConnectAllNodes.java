package UnionFind;

import MergeIntervals.Interval;

import java.util.Arrays;

public class MinCostToConnectAllNodes {
    public int minCostToConnectAllNodes(int n, int [][] edges, int[][] newEdges){
        UnionFind3 uf = new UnionFind3(n);
        Arrays.sort(newEdges,(a, b) -> Integer.compare(a[2],b[2]));
        for(int[] edge :edges){
            uf.union(edge[0],edge[1]);
        }
        System.out.println(uf.components);
        int cost = 0;
        for(int[] edge: newEdges){
            if(!uf.isConnected(edge[0],edge[1])){
                cost += edge[2];
                uf.union(edge[0],edge[1]);
            }

            if(uf.components == 1){
                return cost;
            }
        }

        return -1;
    }

    public static void main(String args[]){
        MinCostToConnectAllNodes mc = new MinCostToConnectAllNodes();
        int n = 6;
        int[][] edges = new int[][]{{1, 4}, {4, 5}, {2, 3}};
        int[][] newEdges = new int[][]{{1,2,5},{1,3,10},{1,6,2},{5,6,5}};

        System.out.println(mc.minCostToConnectAllNodes(n,edges,newEdges));
    }
}

class UnionFind3{
    int[] parent;
    int size;
    int sz[];
    int components;

    UnionFind3(int size){
        this.size = size;
        parent = new int[size+1];
        sz = new int[size+1];
        this.components = size;
        for(int i=1;i<=size;i++){
            parent[i] = i;
        }

        for(int i=1;i<=size;i++){
            sz[i] = 1;
        }
    }

    public boolean isConnected(int i, int j){
        return find(i) == find(j);
    }

    public int find(int root){
        int node = root;

        while(parent[node] != node){
            node = parent[node];
        }

        while(root != node){
            parent[root] = node;
            root = parent[root];
        }
        return node;
    }

    public void union(int i, int j){
        int root_i = find(i);
        int root_j = find(j);

        if(root_i != root_j){
            if(sz[root_i] > sz[root_j]){
                parent[root_j] = parent[root_i];
                sz[root_i] += sz[root_j];
            }else{
                parent[root_i] = parent[root_j];
                sz[root_j] += sz[root_i];
            }
            components--;
        }
        return;
    }
}
