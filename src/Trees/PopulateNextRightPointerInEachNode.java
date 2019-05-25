package Trees;

import java.util.LinkedList;
import java.util.Queue;


// Definition for a Node2.
class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;
    public Node2 next;

    public Node2() {}

    public Node2(int _val,Node2 _left,Node2 _right,Node2 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulateNextRightPointerInEachNode {
    public Node2 connect(Node2 root) {

        if(root == null)
            return root;

        Queue<Node2> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(queue.size() > 0){

            Node2 n = queue.poll();
            if(n != null){
                n.next = queue.peek();
            }else{
                if(queue.size() != 0){
                    queue.add(null);
                    continue;
                }else{
                    break;
                }
            }

            if(n.left != null){
                queue.add(n.left);
            }

            if(n.right != null){
                queue.add(n.right);
            }

        }
        return root;
    }
}