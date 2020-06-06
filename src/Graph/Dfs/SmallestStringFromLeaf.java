package Graph.Dfs;

public class SmallestStringFromLeaf {
     /*
    Intitially I thought this problem can be soved using the Dfs by the post order
    traversal where each node returns the lexicographically smaller string by appending it's character to the string received from the nodes in the below levels. 
    But the test cases line "[4,0,1,1]", return "be" instead of "bae".
    To solve the issue, we need we need to append the current node character before post order and the returning of the lexicographically smaller string needs to be done after post order traversal.
    
        public String smallestFromLeaf(TreeNode root) {
            return dfs(root);
        }

        public String dfs(TreeNode root) {
            if(root != null) {
            }
               
                String left = dfs(root.left);
                String right = dfs(root.right);

                if(left.length() >0 && right.length()>0) {
                    int comp = left.compareTo(right);
                    if(comp <= 0){
                        return left+(char)(root.val+'a');
                    }
                    return right+(char)(root.val+'a');
                }

                if(left.length() >0) {
                    return left+(char)(root.val+'a');
                }
               // if(right.length() >0) {
                    return right+(char)(root.val+'a');
                //}
            }
            return "";
        }
        */
    
    /*
    
    */
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }

    public String dfs(TreeNode root, String suffix) {
        if(root == null) {
            return suffix;
        }
        
        suffix = (char)(root.val+'a') + suffix;
        
        if(root.left == null && root.right == null) {
            return suffix;
        }
        
        if(root.left == null || root.right == null) {
            return (root.left == null) ? dfs(root.right, suffix):dfs(root.left, suffix);
        }
        
        String left = dfs(root.left, suffix);
        String right = dfs(root.right, suffix);
        
        return (left.compareTo(right) <= 0) ? dfs(root.left, suffix) : dfs(root.right, suffix);
    }

    public static void main(String args[]) {
        SmallestStringFromLeaf ssf = new SmallestStringFromLeaf();
        ssf.smallestFromLeaf(root);
    }
}