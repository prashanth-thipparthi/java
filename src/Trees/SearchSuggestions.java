package Trees;
import java.util.*;

public class SearchSuggestions {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();

        int len = searchWord.length();
        TreeMap<String,Integer> treeMap = new TreeMap<>();
        Arrays.sort(products);

        for(int i=0; i<products.length; i++) {
            treeMap.put(products[i],i);
        }

        StringBuilder sb = new StringBuilder("");

        for(int i=0; i<len; i++) {
            sb.append(searchWord.charAt(i));

            String ceilingKey = treeMap.ceilingKey(sb.toString());
            System.out.println("ceilingKey:"+ceilingKey);
            String floorKey = treeMap.floorKey(sb.toString()+"|");
            System.out.println("floorKey:"+floorKey);
        }
        return ans;
    }

    public static void main(String args[]) {
        SearchSuggestions ss = new SearchSuggestions();
        String products[] = new String[] {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        List<List<String>> res = ss.suggestedProducts(products, searchWord);

        for(List<String> result : res) {
            System.out.println(result);
        }
    }
}