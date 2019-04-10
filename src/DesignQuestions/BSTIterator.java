package DesignQuestions;


import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack = new Stack();

    BSTIterator(TreeNode root){
        pushToLeft(root);
    }

    public void pushToLeft(TreeNode root){
        if(root!=null){
            stack.push(root);
            pushToLeft(root.left);
        }
    }

    public  boolean hasNext(){
        if(stack.isEmpty()){
            return false;
        }
        return true;
    }

    public int next(){
        if(hasNext()){
            TreeNode node = stack.pop();
            pushToLeft(node.right);
            return node.val;
        }
        return -1;
    }
}
