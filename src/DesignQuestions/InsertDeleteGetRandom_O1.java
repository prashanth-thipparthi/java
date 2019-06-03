package DesignQuestions;
import java.util.*;

/*
https://leetcode.com/problems/insert-delete-getrandom-o1/
https://leetcode.com/problems/insert-delete-getrandom-o1/discuss/85401/Java-solution-using-a-HashMap-and-an-ArrayList-along-with-a-follow-up.-(131-ms)
 */
public class InsertDeleteGetRandom_O1 {

        List<Integer> nums = null;
        Map<Integer,Integer> locations = null;
        Random rand = null;
        /** Initialize your data structure here. */
        public InsertDeleteGetRandom_O1() {
            nums = new ArrayList<>();
            locations = new HashMap<>();
            rand = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(locations.containsKey(val)){
                return false;
            }else{
                locations.put(val,nums.size());
                nums.add(val);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!locations.containsKey(val)){
                return false;
            }else{
                int loc = locations.get(val);
                if(loc < nums.size()-1){
                    int lastOne = nums.get(nums.size()-1);
                    locations.put(lastOne, loc);
                    nums.set(loc,lastOne);
                }
                locations.remove(val);
                nums.remove(nums.size()-1);
                return true;
            }

        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

