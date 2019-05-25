package BasicDataStructures.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {

        if(k == 0)
            return num;

        Deque<Character> stack = new ArrayDeque<Character>();

        for(char ch : num.toCharArray()){
            while(k>0 && !stack.isEmpty() && stack.peekLast() > ch){
                stack.removeLast();
                k--;
            }
            stack.addLast(ch);
        }

        while(k>0){
            stack.removeLast();
            k--;
        }

        while(!stack.isEmpty() && stack.peekFirst() == '0'){
            stack.removeFirst();
        }

        StringBuilder sb = new StringBuilder();
        int len = stack.size();
        for(int i = 0;i<len;i++){
            sb.append(stack.removeFirst());
        }

        if(sb.length()== 0){
            return "0";
        }
        return sb.toString();
    }

    public static void main(String args[]){
        RemoveKDigits rkd = new RemoveKDigits();
        String num = "1432219";
        int k = 3;
        System.out.println("ans: "+rkd.removeKdigits(num,k));
    }
}
