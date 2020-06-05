package TopologicalSort;
import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        /*
            //similar to the coloring method used to determine topological order of nodes in graph
            nodeState = -1; not exists in words
                      = 0; exists but not visited            
                      = 1; visiting
                      = 2; visited
        */
        int N=26;
        int[] vertices_nodeState = new int[N];
        boolean[][] adjMatrix = new boolean[N][N];
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        createAdjacencyMatrix(vertices_nodeState, adjMatrix, words);
        
        for(int i=0; i<N; i++) {
            if(vertices_nodeState[i] == 0 && dfs_isCyclic(adjMatrix, vertices_nodeState, stack, i) == true){
                return "";   
            }
        }
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }
    
    public boolean dfs_isCyclic(boolean[][] adjMatrix, int[] vertices_nodeState, Stack<Character> stack, int i) {
        if(vertices_nodeState[i] == 2) {
            return false;
        }
        
        vertices_nodeState[i] = 1;
        
        for(int j=0; j<26; j++) {
            if(adjMatrix[i][j]) {
                if(vertices_nodeState[j] == 0) {
                    if(dfs_isCyclic(adjMatrix, vertices_nodeState, stack, j) == true){
                        return true;   
                    }
                } else if(vertices_nodeState[j] == 1) {
                    return true;
                }   
            }            
        }
        
        vertices_nodeState[i] = 2;
        char c =(char) (i+'a');
        stack.push(c);
        return false;
    }
    
    public void createAdjacencyMatrix(int[] vertices, boolean[][] adjMatrix, String[] words) {
        Arrays.fill(vertices, -1);
        
        for(int i=0; i<words.length; i++) {
            for(char ch : words[i].toCharArray()) {
                vertices[ch-'a'] = 0;
            }  
            
            if(i > 0) {
                String w1 = words[i-1];
                String w2 = words[i];
                int len = Math.min(w1.length(), w2.length());   
                if (!w1.equals(w2) && w1.startsWith(w2)) {
                    Arrays.fill(vertices, 2);
                    return;
                }
                for(int j=0; j<len; j++) {
                    if(w1.charAt(j) != w2.charAt(j)) {
                        adjMatrix[w1.charAt(j)-'a'][w2.charAt(j)-'a'] = true;
                        break;
                    }
                }
            }
        }
    }
}