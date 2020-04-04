package MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Definition for an interval.
 * */

//  class Interval {
//      int start;
//      int end;
//      Interval() { start = 0; end = 0; }
//      Interval(int s, int e) { start = s; end = e; }
//  }


public class MeetingRoomsI {
    public boolean minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval first, Interval second){
                return first.start - second.start;
            }
        });

        for(int i=0;i<intervals.length-1;i++){
            if(intervals[i].end>intervals[i+1].start){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        Interval i1 = new Interval(0,4);
        Interval i2 = new Interval(5,10);
        Interval i3 = new Interval(15,20);

        Interval interval[]  = {i1,i2,i3};
        MeetingRoomsI mr = new MeetingRoomsI();

        System.out.println(mr.minMeetingRooms(interval));
    }
}

