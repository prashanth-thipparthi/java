package LinkedList;


class ListNode
{
    int val;
    ListNode next;
    ListNode(int data)
    {
        this.val =data;
    }
}

// Java program to merge k sorted arrays of size n each
public class MergingKSortedLinkedLists {

    /* Takes two lists sorted in increasing order, and merge
    their nodes together to make one big sorted list. Below
    function takes O(Log n) extra space for recursive calls,
    but it can be easily modified to work with same time and
    O(1) extra space  */

//    public static ListNode SortedMerge(ListNode a, ListNode b)
//    {
//        ListNode result = null;
//        /* Base cases */
//        if (a == null)
//            return b;
//        else if(b == null)
//            return a;
//
//        /* Pick either a or b, and recur */
//        if(a.val <= b.val)
//        {
//            result = a;
//            result.next = SortedMerge(a.next, b);
//        }
//        else
//        {
//            result = b;
//            result.next = SortedMerge(a, b.next);
//        }
//
//        return result;
//    }
//
//    // The main function that takes an array of lists
//    // arr[0..last] and generates the sorted output
//    public static ListNode mergeKLists(ListNode arr[], int last)
//    {
//        // repeat until only one list is left
//        while (last != 0)
//        {
//            int i = 0, j = last;
//
//            // (i, j) forms a pair
//            while (i < j)
//            {
//                // merge List i with List j and store
//                // merged list in List i
//                arr[i] = SortedMerge(arr[i], arr[j]);
//
//                // consider next pair
//                i++; j--;
//
//                // If all pairs are merged, update last
//                if (i >= j)
//                    last = j;
//            }
//        }
//
//        return arr[0];
//    }

    public ListNode sortedMerge(ListNode node1, ListNode node2){
        ListNode result = null;

        if(node1==null){
            return node2;
        }

        if(node2==null){
            return node1;
        }

        if(node1.val<=node2.val){
            result = node1;
            result.next = sortedMerge(result.next,node2);
        }else{
            result = node2;
            result.next = sortedMerge(node1,result.next);
        }

        return result;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int last = lists.length-1;
        while(last !=0){
            int i=0,j=last;
            while(i<j){
                lists[i] = sortedMerge(lists[i],lists[j]);
                i++;
                j--;
                if(i>=j){
                    last = j;
                }
            }
        }
        return lists[0];
    }

    /* Function to print nodes in a given linked list */
    public static void printList(ListNode listNode)
    {
        while (listNode != null)
        {
            System.out.print(listNode.val +" ");
            listNode = listNode.next;
        }
    }

    public static void main(String args[]) {
        int k = 3; // Number of linked lists
        int n = 4; // Number of elements in each list

        // an array of pointers storing the head nodes
        // of the linked lists
        ListNode arr[]=new ListNode[k];

        arr[0] = new ListNode(1);
        arr[0].next = new ListNode(4);
        arr[0].next.next = new ListNode(5);
//        arr[0].next.next.next = new ListNode(7);

        arr[1] = new ListNode(1);
        arr[1].next = new ListNode(3);
        arr[1].next.next = new ListNode(4);
        //arr[1].next.next.next = new ListNode(8);

        arr[2] = new ListNode(2);
        arr[2].next = new ListNode(6);
        //arr[2].next.next = new ListNode(10);
        //arr[2].next.next.next = new ListNode(11);

        // Merge all lists
        MergingKSortedLinkedLists mll = new MergingKSortedLinkedLists();
        ListNode head = mll.mergeKLists(arr);
        printList(head);
    }
}


