package Array;

import java.util.*;

public class QueuePractice {

    public static void main(String args[]){

//        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });
//
//        Queue<Integer> q = new PriorityQueue<>();
//
//        q.add(4);
//        q.add(2);
//        q.add(5);
//
//        System.out.println("Q.remove:"+q.remove());
//        System.out.println("Q.remove:"+q.poll());
//        q.add(1);
//
//        System.out.println("Q.remove:"+q.remove());

        List<List<Integer>> list = new ArrayList<>();

        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);

        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(3);

        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(1);
        l3.add(2);
        l3.add(3);

        list.add(l1);
        list.add(l2);
        list.add(l3);

        for (List<Integer> al : list){
            for(int a:al){
                System.out.println("List:"+a);
            }
        }

    }
}
