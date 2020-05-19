package TwoPointers;

import java.util.*;

/*
https://leetcode.com/discuss/interview-question/373202
*/

public class OptimalUtilisation {
    private List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
        Collections.sort(a, new Comparator<int[]>(){
            public int compare(int[] a1, int[] a2){
                return a1[1] - a2[1];
            }
        });

        Collections.sort(b, new Comparator<int[]>(){
            public int compare(int[] b1, int[] b2){
                return b1[1] - b2[1];
            }
        });

        List<int[]> answer = new ArrayList<int[]>();
        int closest = Integer.MIN_VALUE;
        int i=0,j=0;
        int l1 = a.size();
        int l2 = b.size();

        while(i<l1 && j<l2) {
            int sum = a.get(i)[1]+b.get(j)[1];
            if(sum > target) {
                j++;
            }else {
                if(sum > closest) {
                    answer.clear();
                    closest = sum;                    
                }
                answer.add(new int[]{a.get(i)[0],b.get(j)[0]});
                int index = j-1;
                while(index>=0 && index <l2 && (b.get(index)[1] ==  b.get(index+1)[1])) {
                    answer.add(new int[]{a.get(i)[0],b.get(j)[0]});
                    index++;
                }
            }
            i++;
        }
        return answer;
    }    

    public static void main(String args[] ) {
        List<int[]> a = new ArrayList<>();
        a.add(new int[]{1, 2});
        a.add(new int[]{2, 4});
        a.add(new int[]{3, 6});

        List<int[]> b = new ArrayList<>();
        b.add(new int[]{1, 2});

        OptimalUtilisation opu = new OptimalUtilisation();
        List<int[]> ans = opu.getPairs(a, b, 7);
        for(int[] an : ans) {
            System.out.println("pair:"+an[0]+","+an[1]);
        }
    }
}