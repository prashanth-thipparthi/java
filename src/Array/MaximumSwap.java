package Array;

/* https://leetcode.com/problems/maximum-swap/
* https://leetcode.com/problems/maximum-swap/discuss/107068/Java-simple-solution-O(n)-time
* */
public class MaximumSwap {

    /*
    We can use both the HashMap and Array to store the digits index but
    usage of hashMap beas 52 % and usage of array beats 100 %
     */


    public void swap(char [] nums, int index1, int index2){

        char c = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = c;
    }

    public int maximumSwap(int num) {


        String s = String.valueOf(num);

        char nums[] = s.toCharArray();

        int buckets[] = new int[10];
        for(int i=0; i<nums.length; i++){
            buckets[i] = -1;
        }
        for(int i=0; i<nums.length; i++){
            buckets[nums[i]-'0'] = i;
        }
       /*
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i]-'0',i);
        }
        */
        /*
        for(Integer key : hm.keySet()){
            int value = hm.get(key);
            System.out.println(key +" : "+ value);
        }*/
        for(int i=0; i<nums.length; i++){
            int digit = nums[i] - '0';
            for(int k=9; k > digit; k--){
                if( buckets[k] != -1 && buckets[k] > i ){
                    swap(nums,i,buckets[k]);
                    String s1 = new String(nums);
                    return Integer.valueOf(s1);
                }
            }
        }
        return num;
    }
}
