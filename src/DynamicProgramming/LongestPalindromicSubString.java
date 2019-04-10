package DynamicProgramming;

public class LongestPalindromicSubString {

    /*
    public String longestPalindrome(String s){

        int len = s.length();

        if(s == null || len <2){
            return s;
        }

        boolean[][] isPalindrome = new boolean[len][len];

        int left = 0;
        int right = 0;

        for(int j=1;j<len;j++){
            for(int i=0;i<j;i++){
                boolean isInnerWordPalindrome = isPalindrome[i+1][j-1] || j-i <= 2;
                if(s.charAt(i) == s.charAt(j) && isInnerWordPalindrome){
                    isPalindrome[i][j] = true;

                    if(j-i > right-left){
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left,right+1);
    }
    */

    public String longestPalindrome(String s) {
        int n = s.length();
        int palindromeBeginsAt = 0; //index where the longest palindrome begins
        int maxLen = 1;//length of the longest palindrome
        boolean palindrome[][] = new boolean[n][n]; //boolean table to store palindrome truth

        //Trivial case: single letter palindromes
        for (int i = 0; i < n; i++) {
            palindrome[i][i] = true;
        }

        //Finding palindromes of two characters.
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                palindrome[i][i + 1] = true;
                palindromeBeginsAt = i;
                maxLen = 2;
            }
        }

        //Finding palindromes of length 3 to n and saving the longest
        for (int curLen = 3; curLen <= n; curLen++) {
            for (int i = 0; i < n - curLen + 1; i++) {
                int j = i + curLen - 1;
                if (s.charAt(i) == s.charAt(j) //1. The first and last characters should match
                        && palindrome[i + 1][j - 1]) //2. Rest of the substring should be a palindrome
                {
                    palindrome[i][j] = true;
                    palindromeBeginsAt = i;
                    maxLen = curLen;
                }
            }
        }
        return s.substring(palindromeBeginsAt, maxLen + palindromeBeginsAt);
    }

    public static void main(String args[]){
        LongestPalindromicSubString lps = new LongestPalindromicSubString();
        System.out.println("Palindromic SubString: "+lps.longestPalindrome("banana"));
    }
}
