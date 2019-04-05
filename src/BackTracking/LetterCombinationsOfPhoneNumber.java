package BackTracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();

        Map<Character,char[]> numbersMap = new HashMap<>();
        numbersMap.put('0',new char[]{});
        numbersMap.put('1',new char[]{});
        numbersMap.put('2',new char[]{'a','b','c'});
        numbersMap.put('3',new char[]{'d','e','f'});
        numbersMap.put('4',new char[]{'g','h','i'});
        numbersMap.put('5',new char[]{'j','k','l'});
        numbersMap.put('6',new char[]{'m','n','o'});
        numbersMap.put('7',new char[]{'p','q','r','s'});
        numbersMap.put('8',new char[]{'t','u','v'});
        numbersMap.put('9',new char[]{'w','x','y','z'});

        StringBuilder sb = new StringBuilder();
        letterCombinationsUtil(digits,sb,numbersMap,result);
        return result;
    }

    public void letterCombinationsUtil(String digits, StringBuilder sb,Map<Character,char[]> numbersMap, List<String> result){
        if(sb.length()==digits.length()){
            result.add(sb.toString());
            return;
        }

        for(char ch:numbersMap.get(digits.charAt(sb.length()))){
            sb.append(ch);
            letterCombinationsUtil(digits,sb,numbersMap,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String args[]){
        String digits = "23";
        LetterCombinationsOfPhoneNumber lcpn = new LetterCombinationsOfPhoneNumber();
        List<String> combinations = lcpn.letterCombinations(digits);
        for(String c:combinations){
            System.out.println(c);
        }
    }
}
