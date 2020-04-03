package Strings;

/*O(n) - time ;; O(n) - space */
public class ReverseWordsInString1 {
    public String reverse(String[] words){
        int len = words.length;
        //System.out.println(len);
        for(int i=0, j=len-1; i<len/2 && j>=len/2; i++,j--){
            String temp = words[i];//.trim();
            words[i] = words[j];//.trim();
            words[j] = temp;            
        }
       
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<len;i++){
            if(!words[i].trim().equals("")){
                sb.append(words[i].trim() +" ");    
            }            
        }
        return sb.toString();
    }
    public String reverseWords(String s) {
        String[] splitWords = s.split(" ");        
        return reverse(splitWords).trim();
    }
}