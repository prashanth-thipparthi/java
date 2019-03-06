package Strings;

/*
03/01/2019
 */
public class IsSubString {
    public static  int isSubString(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();

        int i= 0,j= 0,k= 0;

        while(j < len2){
            if(s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }else{
                i = 0;
                k++;
                j = k;
            }
            if(i==len1){
                return j-len1;
            }
        }
        return 0;
    }

    /*
Computes temporary array to maintain size of suffix which is same as prefix
 */
    public static int[] computePatternSuffixArray(char[] pattern){
        int lps[] = new int[pattern.length];
        int index = 0;
        for(int i=1;i<pattern.length;){
            if(pattern[i] == pattern[index]){
                lps[i] = index +1;
                i++;
                index++;
            } else{
                if(index != 0){
                    index = lps[index-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static int kmpStringMatching(char[] s1, char[] s2){

        int len1 = s1.length;
        int len2 = s2.length;
        int lps[] = computePatternSuffixArray(s1);
        int i= 0,j= 0,k= 0;

        while(j < len2){
            if(s1[i] == s2[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
            if(i==len1){
                return j-len1;
            }
        }
        return 0;

    }


    public static void main(String args[]){
        String str1 = "abcabyu";
        String str2 = "abxabcabcaby";
       // int ret = isSubString(str1,str2);
        int ret = kmpStringMatching(str1.toCharArray(), str2.toCharArray());
        if(ret == 0){
            System.out.println("String 1 is not a sub string of string b");
        }else{
            System.out.println("String 1 is a sub string of string b");
        }

    }
}
