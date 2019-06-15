package slidingWindow;

public class LongestSubStringWithAtMostKDistinctChars {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start = 0, end = 0, maxLen = Integer.MIN_VALUE;
        int counter = 0;
        int ch[] = new int[128];
        while(end < s.length()){
            final char c1 = s.charAt(end);
            if(ch[c1] == 0)
                counter++;
            ch[c1]++;
            end++;
            while(counter > k){
                final char c2 = s.charAt(start);
                if(ch[c2] == 1)
                    counter--;
                ch[c2]--;
                start++;
            }

            maxLen = Math.max(maxLen, end-start);
        }
        // System.out.println("start: "+start+"end: "+end);
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
