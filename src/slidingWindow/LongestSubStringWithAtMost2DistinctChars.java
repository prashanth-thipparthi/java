package slidingWindow;

/*
https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters

https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
 */
public class LongestSubStringWithAtMost2DistinctCars {
    public int lengthOfLongestSubstringTwoDistinct(String s) {


        int start = 0, end = 0, maxLen = Integer.MIN_VALUE;
        int counter = 0;
        int ch[] = new int[128];
        while(end < s.length()){
            final char c1 = s.charAt(end);
            if(ch[c1] == 0)
                counter++;
            ch[c1]++;
            end++;
            while(counter > 2){
                final char c2 = s.charAt(start);
                if(ch[c2] == 1)
                    counter--;
                ch[c2]--;
                start++;
            }

            maxLen = Math.max(maxLen, end-start);
        }
        System.out.println("start: "+start+"end: "+end);
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
