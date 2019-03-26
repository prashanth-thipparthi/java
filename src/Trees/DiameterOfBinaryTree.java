package Trees;

import java.util.Scanner;

public class DiameterOfBinaryTree {
    private BTNode root;

    public static Scanner scan = new Scanner(System.in);

    public DiameterOfBinaryTree(){
        root = null;
    }

    public boolean isEmpty(){
        return (root==null);
    }

    public void BSTInsert(int data)
    {
        root = BSTInsert(root, data);
    }

    public BTNode BSTInsert(BTNode head,int data){
        BTNode tempHead = head;
        BTNode newNode = new BTNode(data);
        BTNode prev = null;
        if(head == null){
            head = newNode;
            return head;
        }

        while(head!=null){
            prev = head;
            if(head.data<=data){
                head = head.right;
            }else{
                head = head.left;
            }
        }

        if(prev.data<=data){
            prev.right = newNode;
        }else{
            prev.left = newNode;
        }
        return tempHead;
    }

    public int heightOfBinaryTree(BTNode node){
        if(node == null)
            return 0;
        return 1+Math.max(heightOfBinaryTree(node.left),heightOfBinaryTree(node.right));
    }

    public int diameterOfBinaryTree(){
        return diameterOfBinaryTreeUtil(root);
    }

    public int diameterOfBinaryTreeUtil(BTNode node){

        if(node == null)
            return 0;

        int leftHeight = heightOfBinaryTree(node.left);
        int rightHeight = heightOfBinaryTree(node.right);

        int leftDiameter = diameterOfBinaryTreeUtil(node.left);
        int rightDiameter = diameterOfBinaryTreeUtil(node.right);

        int maxDiameter = Math.max(leftHeight+rightHeight+1,Math.max(leftDiameter,rightDiameter));

        return maxDiameter;
    }

    public static void main(String args[]){
        DiameterOfBinaryTree dbt = new DiameterOfBinaryTree();
        /*
        System.out.println("Enter the number of elements to insert:");
        int n = scan.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
            dbt.BSTInsert(arr[i]);
        }
        */
        dbt.root = new BTNode(1);
        dbt.root.left = new BTNode(2);
        dbt.root.right = new BTNode(3);
        dbt.root.left.left = new BTNode(4);
        dbt.root.left.right = new BTNode(5);
        dbt.root.right.left = new BTNode(6);
        dbt.root.right.right = new BTNode(7);
        dbt.root.left.left.left = new BTNode(8);
        dbt.root.left.left.right = new BTNode(9);
        //System.out.println("Height of binary Tree:"+dbt.heightOfBinaryTree(dbt.root));
        System.out.println("Diameter of a Binary Tree:"+dbt.diameterOfBinaryTree());

    }
}
