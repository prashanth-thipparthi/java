package LinkedList;

public class InteresectionOfLinkedLists {

    /*
    One of the cleverest solution and representation
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }

    public static void main(String args[]){
        InteresectionOfLinkedLists ioll = new InteresectionOfLinkedLists();
        ListNode arr = new ListNode(1);
        arr.next = new ListNode(4);
        arr.next.next = new ListNode(5);
//        arr[0].next.next.next = new ListNode(7);

        ListNode arr1 = new ListNode(1);
        arr1.next = new ListNode(3);
        arr1.next.next = new ListNode(4);
        ioll.getIntersectionNode(arr,arr1);
    }
}
