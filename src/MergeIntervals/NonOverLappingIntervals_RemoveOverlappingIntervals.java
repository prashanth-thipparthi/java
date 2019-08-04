package MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

class myComparator implements Comparator<Interval> {
    public int compare(Interval a, Interval b) {
        return a.end - b.end;
    }
}

public class NonOverLappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0)  return 0;

        Arrays.sort(intervals, new myComparator());
        int end = intervals[0].end;
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }
    public static void main(String args[]){
        NonOverLappingIntervals noi = new NonOverLappingIntervals();
        Interval i1 = new Interval();
        
        noi.eraseOverlapIntervals()
    }
}

