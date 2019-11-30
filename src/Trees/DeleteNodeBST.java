/*
https://leetcode.com/problems/delete-node-in-a-bst/
*/
package Trees;

import java.util.*;

public class DeleteNodeBST {
    public int successor(TreeNode root) {
        
        root = root.right;
        while(root.left != null) {
            root = root.left;
        }
        return root.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(root.val > key ) {
            root.left = deleteNode(root.left, key);
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left != null && root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }else{
                root = (root.left!=null) ?root.left : root.right;
            }
        }

        return root;
    }

    public static void main(String args[]) {

    }
}