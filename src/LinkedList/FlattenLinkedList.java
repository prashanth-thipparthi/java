package LinkedList;

import java.util.LinkedList;

public class FlattenLinkedList {

    Node head;  // head of list

    /* Linked list Node*/
    class Node
    {
        int data;
        Node right, down;
        Node(int data)
        {
            this.data = data;
            right = null;
            down = null;
        }
    }


    /* Utility function to insert a node at begining of the
    linked list */
    Node push(Node head_ref, int data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(data);

        /* 3. Make next of new Node as head */
        new_node.down = head_ref;

        /* 4. Move the head to point to new Node */
        head_ref = new_node;

        /*5. return to link it back */
        return head_ref;
    }

    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.down;
        }
        System.out.println();
    }
    public Node sortedMerge(Node node1, Node node2){
        Node result = null;

        if(node1==null){
            return node2;
        }

        if(node2==null){
            return node1;
        }

        if(node1.data<=node2.data){
            result = node1;
            result.down = sortedMerge(result.down,node2);
        }else{
            result = node2;
            result.down = sortedMerge(node1,result.down);
        }
        return result;
    }

    Node flatten(Node head) {
        if(head == null || head.right == null) {
            return head;
        }

        head.right = flatten(head.right);

        head = sortedMerge(head, head.right);

        return head;
    }

    /* Drier program to test above functions */
    public static void main(String args[])
    {
        FlattenLinkedList L = new FlattenLinkedList();

        /* Let us create the following linked list
            5 -> 10 -> 19 -> 28
            |    |     |     |
            V    V     V     V
            7    20    22    35
            |          |     |
            V          V     V
            8          50    40
            |                |
            V                V
            30               45
        */

        L.head = L.push(L.head, 30);
        L.head = L.push(L.head, 8);
        L.head = L.push(L.head, 7);
        L.head = L.push(L.head, 5);

        L.head.right = L.push(L.head.right, 20);
        L.head.right = L.push(L.head.right, 10);

        L.head.right.right = L.push(L.head.right.right, 50);
        L.head.right.right = L.push(L.head.right.right, 22);
        L.head.right.right = L.push(L.head.right.right, 19);

        L.head.right.right.right = L.push(L.head.right.right.right, 45);
        L.head.right.right.right = L.push(L.head.right.right.right, 40);
        L.head.right.right.right = L.push(L.head.right.right.right, 35);
        L.head.right.right.right = L.push(L.head.right.right.right, 20);

        // flatten the list
        L.head = L.flatten(L.head);

        L.printList();
    }
}
