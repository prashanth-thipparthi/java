package sortingAlgorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public int minMeetingRooms(Interval[] intervals) {

        if(intervals == null || intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        //Arrays.sort(intervals,(a,b)->a.start-b.start);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.offer(intervals[0].end);
        int count = 1;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i].start<minHeap.peek()){
                count++;
            }else{
                minHeap.poll();
            }
            minHeap.offer(intervals[i].end);
        }
        return count;
    }

    public static void main(String args[]){
        Interval i1 = new Interval(0,15);
        Interval i2 = new Interval(5,10);
        Interval i3 = new Interval(15,20);

        Interval interval[]  = {i1,i2,i3};
        MeetingRoomsII mr = new MeetingRoomsII();

        System.out.println("Minimum Number of rooms required: "+mr.minMeetingRooms(interval));
    }
}
