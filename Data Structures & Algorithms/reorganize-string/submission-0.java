class Solution {
    public String reorganizeString(String s) {
        
        int[] cnt = new int[26];
        int total = 0;
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
            total++;
        }


        char maxChar = s.charAt(0);
        int maxCnt = 0;
        for(int i = 0; i < cnt.length; i++){
            if(cnt[i] > maxCnt){
                maxCnt = cnt[i];
                maxChar = (char)('a' + i);
            }
        }

        if(maxCnt > (s.length()+1)/2){
            return "";
        }

        

        char[] res = new char[s.length()];
        int idx = 0;
        while(cnt[maxChar-'a'] > 0){
            res[idx] = maxChar;
            idx += 2;
            cnt[maxChar-'a']--;
        }

        for(int i = 0; i < 26; i++){
            while(cnt[i] > 0){
                if(idx >= s.length()){
                    idx = 1;
                }
                res[idx] = (char)('a'+i);
                idx += 2;
                cnt[i]--;
            }
        }

        return new String(res);


    }
}