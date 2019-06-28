package Searching.dfs;

import java.util.*;
/*
https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 */

public class ConnectedComponentsUndirectedGraph {
    public int countComponents(int n, int[][] edges) {

        if(n == 0 || edges == null)
            return 0;

        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Stack<Integer> dfs = new Stack<Integer>();
        int components = 0;

        for(int i=0; i<n; i++){
            adjList.put(i, new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                components++;
                dfs.push(i);

                while(!dfs.empty()){
                    int current = dfs.pop();
                    visited[current] = true;

                    for(int adj : adjList.get(current)){
                        if(!visited[adj])
                            dfs.push(adj);
                    }
                }
            }
        }
        return components;
    }
}
