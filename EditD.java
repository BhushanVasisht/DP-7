//TC - O(m*n), m and n are lengths of the two words
//SC - O(m*n)
class Solution {
    public int minDistance(String word1, String word2) {
        if( (word1 == null || word1.length() == 0) && (word2 == null || word2.length() == 0))
            return 0;
        
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        
        for(int i = 0; i < dp.length; ++i)
        {
            dp[i][0] = i;
        }
        
        for(int j = 0; j < dp[0].length; ++j)
        {
            dp[0][j] = j;
        }
        
        for(int i = 1; i < dp.length; ++i)
        {
            for(int j = 1; j < dp[0].length; ++j)
            {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        
        return dp[dp.length-1][dp[0].length-1];
    }
}
