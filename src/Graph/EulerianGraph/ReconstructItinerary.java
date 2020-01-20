package Graph.EulerianGraph;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {

        List<String> res = new ArrayList<>();
        if(tickets == null || tickets.size() == 0)
            return res;

        Map<String, PriorityQueue<String>> hmap = new HashMap<String, PriorityQueue<String>>();

        for(List<String> ticket : tickets){
            String key = ticket.get(0);
            String val = ticket.get(1);

            PriorityQueue<String> pq = hmap.getOrDefault(key, new PriorityQueue<String>((a,b) -> a.compareTo(b)));

            pq.add(val);
            hmap.put(key,pq);
        }

        String source = "JFK";
        res.add(source);

        while(hmap.containsKey(source) && hmap.get(source).size() > 0){
            String val = hmap.get(source).poll();
            res.add(val);
            source = val;
        }

        return res;
    }
    public static void main(String args[]){
        ReconstructItinerary ri = new ReconstructItinerary();
        //[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]

        List<List<String>> list = new ArrayList<>();
        List<String> l1 = new ArrayList<>();
        l1.add("MUC");
        l1.add("LHR");
        List<String> l2 = new ArrayList<>();
        l1.add("JFK");
        l1.add("MUC");
        List<String> l3 = new ArrayList<>();
        l1.add("SFO");
        l1.add("SJC");
        List<String> l4 = new ArrayList<>();
        l1.add("LHR");
        l1.add("SFO");
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        ri.findItinerary(list);
    }
}
