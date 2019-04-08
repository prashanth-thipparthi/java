package DesignQuestions;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private class Node{
        int key,value;
        Node prev,next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
        public Node(){
            this(0,0);
        }
    }

    Node head,tail;
    int capacity,size;
    Map<Integer,Node> hashMap;

    public LRUCache(int capacity){
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        hashMap = new HashMap<>();
    }

    public int get(int key){
        Node n = hashMap.get(key);
        if(n == null){
            return -1;
        }
        update(n);
        return n.value;
    }
    public void put(int key, int value){
        Node n = hashMap.get(key);
        if(n == null){
            n = new Node(key,value);
            hashMap.put(key,n);
            add(n);
            size++;
        }else{
            n.value = value;
            update(n);
        }

        if(size > capacity){
            Node del = tail.prev;
            remove(del);
            hashMap.remove(del.key);
            size--;
        }
    }

    public void update(Node n){
        remove(n);
        add(n);
    }
    public void add(Node n){
        Node first = head.next;
        head.next = n;
        n.next = first;
        first.prev = n;
        n.prev = head;
    }

    public void remove(Node n){
        Node before = n.prev;
        Node after = n.next;
        before.next = after;
        after.prev = before;
    }

    public static void main(String args[]){
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}

