package LinkedList;

public class ValidPalindrome {
    
    public ListNode findMidPoint(ListNode head){
        ListNode oneStep = head;
        ListNode twoStep = head;
        while(twoStep != null && twoStep.next !=null){
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        return oneStep;
    }

    public ListNode reverseSecondHalf(ListNode head){
        ListNode copy = head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = cur.next;
        
        while(cur != null ){
            cur.next = prev;
            prev = cur;
            cur = next;
            if(next != null) {
                next = next.next;    
            }
        }     
        return prev;   
    }

    public boolean compareTwoLists(ListNode head1, ListNode head2){
        while(head1 !=null && head2 != null){
            if(head1.val == head2.val){
                head1 = head1.next;
                head2 = head2.next;    
            }else{
                return false;
            }            
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        //1.find midpoint
        //2.reverse left half of the linkedlist
        //3.compare left half and the right half
        if(head == null){
            return true;
        }
        ListNode copy = head;
        
        ListNode mid = findMidPoint(head);
    //       System.out.println(mid.next.val);
        ListNode secondHalfTail = reverseSecondHalf(mid);
        return compareTwoLists(copy,secondHalfTail);
        
    }

}