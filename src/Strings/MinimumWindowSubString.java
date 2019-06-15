package Strings;

/*
https://leetcode.com/problems/minimum-window-substring

https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
 */
public class MinimumWindowSubString {
    public String minWindow(String s, String t) {


        int map[] = new int[128];

        for(char ch : t.toCharArray()){
            map[ch]++;
        }

        int front = 0; int rear = 0; int counter = t.length();
        int minStart = 0; int min = Integer.MAX_VALUE;

        while(rear < s.length()){
            final char c1 = s.charAt(rear);

            if(map[c1] > 0)
                counter--;
            map[c1]--;
            rear++;
            while(counter == 0){
                final char c2 = s.charAt(front);

                if(rear - front < min){
                    min = rear - front;
                    minStart = front;
                }
                map[c2]++;
                if(map[c2] > 0)
                    counter++;
                front++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+min);
    }
}
