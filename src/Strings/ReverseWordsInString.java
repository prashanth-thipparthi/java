package Strings;

/*
leet code - Reverse Words in a String II
 */

public class ReverseWordsInString {

    public String  removeExtraSpaces(char[] s) {
        int len = s.length;
        
        int i=0;
        int j=0;
        
        while(i < len && j<len) {
            while(j < len && s[j] == ' ') j++;
            while(j < len && s[j] != ' ') {
                s[i++] = s[j++];
            }
            while(j < len && s[j] == ' ') j++;
            if(j < len) s[i++] = ' ';
        }
        
        return new String(s).substring(i);
    }
    
    public void reverse(char[] s, int i, int j) {
        char temp;
        int len = s.length;
        while(i< j ) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }
    
    public void reverseIndividualWords(char[] ch)   {
        int len = ch.length;
        int i=0;
        int j=0;
        while(i < len && j < len){            
            while(i < j) {
                i++;   // make i and j equal
            }
            while(i < len && ch[i] == ' '){
                i++;
            }
            while(j < i) {
                j++;   // make i and j equal
            }
            while(j < len && ch[j] != ' '){
                j++;
            }
            reverse(ch, i, j-1);
        }
    }
    
    public String reverseWords(String s) {
        if(s.length() == 0){
            return s;
        }
        char[] ch = s.toCharArray();
        reverseIndividualWords(ch);
        reverse(ch,0,ch.length-1);
        return removeExtraSpaces(ch);
    }

    public static void main(String args[]){
        String s1 = "the sky is blue";
        ReverseWordsInString rws = new ReverseWordsInString();
        s1 = rws.reverseWords(s1);
        System.out.println(s1);
    }
}
