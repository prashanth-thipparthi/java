package DynamicProgramming;

public class UniqueBST_i {

    /*https://leetcode.com/problems/unique-binary-search-trees/solution/ */

    /*
    These problem falls under the category of "Catalan Numbers", or "Catalan Sequence" (1,1,2,5,14,42 .. ) with the formula ( (2n)! / ((n+1)! * n!) ).

    In this unique BST problem, for example, if we have n=4, we have to find unique BSTs with 4 nodes, and there is no dependency on sequence
     i.e number of BSTS for the sequence(1,2,3,4) is same as (4,5,6,7). So, we make each node in the sequence as root and check the number of BSTs for left and
     right subtrees. For ex, In the sequence 1,2,3,4 if we make '2' as root,  BST(2) = BST (1) + BST(2) . In the same manner we have to make 1,2,3,4 as roots and 
     sum the number of BSTs for each node. 
    */
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1; // for emtpy tree # of BSTs = 1
        G[1] = 1; // for one node tree # of BSTs = 1

        for(int i=2; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                G[i] += G[j-1] * G[i-j];
            }
        }

        return G[n];
    }

    public static void main(String args[]) {

    }
}