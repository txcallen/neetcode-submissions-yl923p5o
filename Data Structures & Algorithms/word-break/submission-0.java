class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;
        Set<String> set = new HashSet<>(wordDict);

        for(int i = s.length(); i >= 0; i--){
            for(String word : wordDict){
                if(i + word.length() <= s.length()){
                    String sub = s.substring(i, i+word.length());
                    if(set.contains(sub) && dp[i+word.length()]){
                        dp[i] = true;
                    }
                }
                    
            }
        }

        return dp[0];
    }
}