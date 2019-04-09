package DesignQuestions;

import java.util.Collections;
import java.util.PriorityQueue;

public class DataStreamMedian {

    PriorityQueue<Integer> highers = null;
    PriorityQueue<Integer> lowers = null;

    /** initialize your data structure here. */
    public DataStreamMedian() {
        highers = new PriorityQueue<>();
        lowers = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void rebalance(){
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers:lowers;
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers:highers;
        if(biggerHeap.size() - smallerHeap.size()>=2){
            smallerHeap.offer(biggerHeap.poll());
        }
    }

    public void addNum(int num) {
        if(lowers.size()==0||lowers.peek()>num){
            lowers.offer(num);
        }else{
            highers.offer(num);
        }
        rebalance();
    }

    public double findMedian() {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers:highers;
        if(highers.size()==lowers.size()){
            return (highers.peek()+lowers.peek())/2.0;
        }else{
            return biggerHeap.peek();
        }
    }

    public static void main(String args[]){
        DataStreamMedian dsm = new DataStreamMedian();
        dsm.addNum(-1);
        double median = dsm.findMedian(); //-> 1.5
        dsm.addNum(-2);
        median = dsm.findMedian();
        dsm.addNum(-3);
        median = dsm.findMedian();// -> 2
        dsm.addNum(-4);
        median = dsm.findMedian();
        dsm.addNum(-5);
        median = dsm.findMedian();// -> 2
        System.out.println("median:"+median);
    }
}
