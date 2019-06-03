package UnionFind;

public class UnionFind {
    //number of elements in the union find
    int size;

    //total number of componentsin union find
    int numberOfComponents;

    //size of the each component
    int sz[];

    //id[i] points to the parent of i, if id[i] = i, then 'i' is a root node
    int id[];


    public UnionFind(int size){
        if(size <= 0){
            throw new IllegalArgumentException("size <= is not allowed. ");
        }

        this.size = size;
        numberOfComponents = size;

        sz = new int[size];
        id = new int[size];

        for(int i=0; i<size; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    //Find which component/set 'p' belongs to, takes amortized constant time.
    public int find(int p){

        //find the root of the component/set 'p'
        int root = p;
        while(root != id[root]){
            root = id[root];
        }

        //path compression

        while(p != root){
            int next = id[p];
            id[p] = root;
            p = next;
        }
        return root;
    }

    //return whether the elements 'p' and 'q'
    //are in the same component/set or not.
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    // return the size of the component/set 'p'
    //belongs to
    public int componentSize(int p){
        return sz[find(p)];
    }

    //return the number of elements in the
    // UnionFind/Disjoint set
    public int size(){
        return size;
    }

    //return the number of components in Disjoint set
    public int components(){
        return numberOfComponents;
    }

    //Unify the components/sets containing elements 'p' and 'q'
    public void unify(int p, int q){

        int root1 = find(p);
        int root2 = find(q);

        if(root1 == root2)
            return;

        // merge smaller component into the larger one
        if(sz[root1] > sz[root2]){
            sz[root1] +=sz[root2];
            id[root2] = root1;
        }else{
            sz[root2] +=sz[root1];
            id[root1] = root2;
        }
        numberOfComponents--;
    }

    public static void main(String args[]){
                
    }
}
