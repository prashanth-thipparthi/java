package slidingWindow;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubStringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {


        int start = 0, end = 0, maxLen = Integer.MIN_VALUE, counter = 0;
        int map[] = new int[128];
        while(end < s.length()){
            final char c1 = s.charAt(end);
            if(map[c1] != 0)
                counter++;
            map[c1]++;
            end++;
            while(counter > 0){
                final char c2 = s.charAt(start);
                if(map[c2] > 1)
                    counter--;
                map[c2]--;
                start++;
            }
            maxLen = Math.max(maxLen, end-start);
        }
        System.out.println("start: "+start+"end: "+end);
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }

    /*
        public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int  i=0, j=0;
        int max = Integer.MIN_VALUE;
        for(i=0,j=0; i<n && j<n; ){
            if(!map.containsKey(s.charAt(j))){
                map.put(s.charAt(j),j);
                j++;
            }else{
                i = Math.max(i,map.get(s.charAt(j))+1);
                map.put(s.charAt(j),j);
                j++;
            }
            max = max > (j-i) ? max : (j-i);
        }        
        return max == Integer.MIN_VALUE ? 0 : max;
    }
    */
}
