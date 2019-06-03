package DesignQuestions;

import java.util.*;

public class InsertionDeletionGetRandom_O1_withDuplicates {
        Map<Integer, Set<Integer>> locations = null;
        List<Integer> nums = null;
        java.util.Random rand = null;

        /** Initialize your data structure here. */
        public InsertionDeletionGetRandom_O1_withDuplicates() {
            locations = new HashMap<>();
            nums = new ArrayList<Integer>();
            rand = new java.util.Random();
        }


        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {

            if(locations.containsKey(val)){
                locations.get(val).add(nums.size());
                nums.add(val);
                return false;
            }else{
                locations.put(val,new LinkedHashSet<Integer>());
                locations.get(val).add(nums.size());
                nums.add(val);
                return true;
            }
        /*
        boolean contain = locations.containsKey(val);
	    if ( ! contain ) locations.put( val, new LinkedHashSet<Integer>() );
	    locations.get(val).add(nums.size());
	    nums.add(val);
	    return ! contain ;
        */
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            boolean contain = locations.containsKey(val);
            if ( ! contain ) return false;
            int loc = locations.get(val).iterator().next();
            locations.get(val).remove(loc);
            if(loc < nums.size()-1){
                int lastOne = nums.get(nums.size()-1);
                nums.set(loc,lastOne);
                locations.get(lastOne).remove(nums.size()-1);
                locations.get(lastOne).add(loc);
            }
            nums.remove(nums.size()-1);

            if(locations.get(val).isEmpty()){
                locations.remove(val);
            }
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
