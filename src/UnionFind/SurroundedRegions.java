package UnionFind;

/*https://leetcode.com/problems/surrounded-regions/
*
* https://leetcode.com/problems/surrounded-regions/discuss/41617/Solve-it-using-Union-Find
* */

public class SurroundedRegions {
    int rows;
    int cols;
    public void solve(char[][] board) {



        if(board == null || board.length == 0){
            return;
        }
        rows = board.length;
        cols = board[0].length;

        UnionFind1
                uf = new UnionFind1
                (rows * cols + 1);

        int dummyNode = rows * cols;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j] == 'O'){
                    if(i==0 || i==rows-1 || j==0 || j==cols-1)
                        uf.union(node(i,j), dummyNode);

                    if(i>0 && board[i-1][j] == 'O')
                        uf.union(node(i,j),node(i-1,j));

                    if(i<rows-1 && board[i+1][j] == 'O')
                        uf.union(node(i,j),node(i+1,j));

                    if(j>0 && board[i][j-1] == 'O')
                        uf.union(node(i,j),node(i,j-1));

                    if(j<cols-1 && board[i][j+1] == 'O')
                        uf.union(node(i,j),node(i,j+1));
                }
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(uf.isConnected(node(i,j),dummyNode)){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }

    }

    public int node(int i, int j){
        return i * cols + j;
    }
}

class UnionFind1
{

    int id[];

    public UnionFind1
            (int size){
        id = new int[size];

        for(int i=0; i<size; i++){
            id[i] = i;
        }
    }

    public int find(int input){

        int root = input;
        while(root != id[root]){
            root = id[root];
        }

        //Pth compression
        while(id[input] != root){
            int next = id[input];
            id[input] = root;
            input = next;
        }
        return root;
    }

    public void union(int node1, int node2){
        int root1 = find(node1);
        int root2 = find(node2);

        if(root1 == root2){
            return;
        }

        id[root2] = root1;
        return;
    }

    public boolean isConnected(int node1, int node2){
        return find(node1) == find(node2);
    }
}
