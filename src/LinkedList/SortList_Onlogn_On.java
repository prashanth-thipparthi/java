package LinkedList;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;

        List<ListNode> list = new ArrayList<ListNode>();
        while(head != null){
            list.add(head);
            head = head.next;
        }

        list.sort((a,b)-> a.val-b.val);

        Iterator it = list.iterator();
        ListNode dummy = new ListNode(0);

        while(it.hasNext()){
            System.out.println(((ListNode)it.next()).val);
        }
        return head;
    }
}
