package UnionFind;

public class NoOfIslands {

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        UnionFind2
                uf = new UnionFind2
                (rows, cols, grid);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0')
                    continue;
                int pos = i * cols + j;

                if (i < rows - 1 && grid[i + 1][j] == '1') {
                    uf.union(pos, pos + cols);
                }

                if (j < cols - 1 && grid[i][j + 1] == '1') {
                    uf.union(pos, pos + 1);
                }
            }
        }
        return uf.count;
    }
}
class UnionFind2
{

    int count;
    int id[];

    public UnionFind2
            (int rows, int cols, char[][] grid) {
        id = new int[rows * cols];
        count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                }
            }
        }

        for (int i = 0; i < rows * cols; i++) {
            id[i] = i;
        }
    }

    public int find(int element) {

        int root = element;

        while (root != id[root]) {
            root = id[root];
        }

        //compression of the component/set to
        //get amortised time complexity

        while (element != root) {
            int next = id[element];
            id[element] = root;
            element = next;
        }
        return root;
    }

    public void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 == root2) {
            return;
        }

        id[root1] = root2;
        count--;
    }

    public boolean isConnected(int node1, int node2) {
        return (find(node1) == find(node2));
    }
}