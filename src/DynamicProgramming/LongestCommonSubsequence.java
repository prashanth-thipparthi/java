package DynamicProgramming;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int[][] dp = new int[len1][len2];
        for(int i=0; i<dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return longestCommonSubsequence_dfs_util(text1, text2, len1-1, len2-1, dp);
    }
    
    public int longestCommonSubsequence_dfs_util(String text1, String text2, int len1, int len2, int[][] dp){
        if(len1 < 0 || len2 < 0) {
            return 0;
        }
        
        if(dp[len1][len2] >= 0) {
            return dp[len1][len2];
        }
        
        if(text1.charAt(0) == text2.charAt(0)) {
            int ans = 1+longestCommonSubsequence_dfs_util(text1.substring(1), text2.substring(1), len1-1, len2-1, dp);
            dp[len1][len2] =ans;
        }else {
           int left = longestCommonSubsequence_dfs_util(text1.substring(1), text2, len1-1, len2, dp);
           int right = longestCommonSubsequence_dfs_util(text1, text2.substring(1), len1, len2-1, dp);
           dp[len1][len2] = Math.max(left, right);
        }
        
        return dp[len1][len2];
    }
}