package DesignQuestions;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class SerializeDeserializeBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializedDFS(root,sb);
        return sb.toString();
    }

    public void serializedDFS(TreeNode root,StringBuilder sb){
        if(root == null) return ;
        sb.append(root.val).append(" ");
        serializedDFS(root.left, sb);
        serializedDFS(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0)return null;
        String[] list = data.split(" ");
        TreeNode dummy = new TreeNode(0);
        deserializedDFS(list,0,dummy,true,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return dummy.left;
    }

    public  int deserializedDFS(String[]list, int pos,TreeNode par, boolean isLeft,int lower, int upper ){
        if(pos >= list.length)
            return pos;
        int val = Integer.parseInt(list[pos]);

        if(val<lower || val > upper){
            return pos-1;
        }

        TreeNode cur = new TreeNode(val);

        if(isLeft) par.left = cur;
        else par.right = cur;

        pos = deserializedDFS(list,++pos, cur, true, lower, val);
        pos = deserializedDFS(list,++pos, cur, false, val, upper);
        return pos;
    }

    public void preorder(TreeNode root) {

        preorderUtil(root);
    }

    private void preorderUtil(TreeNode r) {
        if (r != null)  {
            System.out.print(r.val +" ");
            preorder(r.left);
            preorder(r.right);
        }
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.left.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);

        root.right =  new TreeNode(14);
        root.right.left =  new TreeNode(11);
        root.right.right =  new TreeNode(18);

        SerializeDeserializeBST sdbst = new SerializeDeserializeBST();
        String serializedString = sdbst.serialize(root);
        TreeNode serializedRoot = sdbst.deserialize(serializedString);
        sdbst.preorder(serializedRoot);
    }
}
