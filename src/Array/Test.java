package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Test {


    public static void main(String args[]){
//        Integer a[] = {1,2,3,4,5,6};
//        ArrayList<Integer> al = new ArrayList<Integer>(Arrays.asList(a));
//        Arrays.sort(a);
//        int x = 00123;
//        System.out.println("x: "+Math.abs(x));
/*
        Set<Integer> lhs = new LinkedHashSet<>();

        lhs.add(1);

        lhs.add(2);
        lhs.add(3);
        lhs.add(4);

        System.out.println("element: "+lhs.iterator().next());

        lhs.remove(new Integer(1));
        System.out.println("element: "+lhs.iterator().next());
        */
        String s = "!@#$%^abcdefghijklmnopqrstuvwxyz";

//        int c = '9' - '0';
//        System.out.println("c: "+  c);

        int ch[] = new int[128];
//        for(int i=0; i<128; i++){
//            ch[i] = 0;
//        }

        for(char c : s.toCharArray()){
            ch[c]++;
        }

        for(int i=0; i<128; i++){
            System.out.print(ch[i] + " ");
        }
    }
}
