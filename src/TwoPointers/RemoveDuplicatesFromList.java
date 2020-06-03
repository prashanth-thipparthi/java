package TwoPointers;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class RemoveDuplicatesFromList {
     /*
     Two Pointer Method.
     Where one pointer moves and the other pointer stiches the list.
    */
    /*
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        ListNode temp1 = head;
        
        while(temp != null) {
            if(head.val != temp.val) {
                head.next = temp;
                head = head.next;
            }
            temp = temp.next;
        }
        
        if(head !=null && head.next != null && head.val == head.next.val) {
            head.next = null;
        }
        return temp1;
    }   */
    
    /* In this approach we drop duplicate nodes and stich through the non-duplicate nodes*/
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        
        while(current != null && current.next != null) {
            if(current.val == current.next.val) {
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        return head;
    }
}