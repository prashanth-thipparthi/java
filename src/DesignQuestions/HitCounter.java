package DesignQuestions;

public class HitCounter {
    int times[];
    int hits[];
    int window;

    public HitCounter(int window){
        this.window = window;
        times = new int[window];
        hits = new int[window];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp%window;
        if(times[index]!=timestamp){
            times[index] = timestamp;
            hits[index] = 1;
        }else{
            hits[index]++;
        }
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int hit = 0;
        for(int i=0;i<window;i++){
            if(timestamp - times[i] < 300){
                hit += hits[i];
            }
        }
        return hit;
    }

    public static void main(String args[]){
        HitCounter counter = new HitCounter(300);

// hit at timestamp 1.
        counter.hit(1);

// hit at timestamp 2.
        counter.hit(2);

// hit at timestamp 3.
        counter.hit(3);

// get hits at timestamp 4, should return 3.
        counter.getHits(4);

// hit at timestamp 300.
        counter.hit(300);

// get hits at timestamp 300, should return 4.
        counter.getHits(300);

// get hits at timestamp 301, should return 3.
        counter.getHits(301);
    }
}
