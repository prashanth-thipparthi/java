package LinkedList;

/**
 * Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }
 */

public class AddTwoNumbers {

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }

        if(head.next == null){
            return head;
        }

        ListNode cur = head.next,prev = head,next = null;
        prev.next = null;

        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        //ans.next = new ListNode(0);
        ListNode dup = ans;
        //ans.next = dup;
        int sum = 0;
        int carry = 0;

        while (l1!=null || l2 != null){
            int a = l1==null ? 0 : l1.val;
            int b = l2==null ? 0 : l2.val;
            sum = a+b+carry;
            dup.next = new ListNode(sum%10);
            carry = sum/10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
            dup = dup.next;
        }

        if(carry>0){
            dup.next = new ListNode(carry);
        }

        return ans.next;
    }

    public static void main(String args[]){
        AddTwoNumbers add = new AddTwoNumbers();

        ListNode list1 = new ListNode(5);
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(3);
        list1.next = n1;
        n1.next = n2;

        ListNode list2 = new ListNode(2);
        ListNode l2n1 = new ListNode(4);
        ListNode l2n2 = new ListNode(8);
        list2.next = l2n1;
        l2n1.next = l2n2;

        ListNode l1 = add.reverseList(list1);
        ListNode l2 = add.reverseList(list2);

        ListNode l3 = add.addTwoNumbers(l1,l2);

        while(l3!=null){
            System.out.println(l3.val);
            l3 = l3.next;
        }


    }
}
