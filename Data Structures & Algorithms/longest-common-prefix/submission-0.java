class Solution {
    Trie root = new Trie();

    public String longestCommonPrefix(String[] strs) {
        
        for(String str : strs){
            buildTrie(str);
        }

        int len = strs.length;
        String start = strs[0];
        StringBuilder sb = new StringBuilder();
        Trie cur = root;
        for(char c : start.toCharArray()){
            if(cur.children[c-'a'] == null || cur.children[c-'a'].cnt < len){
                return sb.toString();
            }else{
                cur = cur.children[c-'a'];
                sb.append(c);
            }
        }

        return sb.toString();
    }

    void buildTrie(String s){
        Trie cur = root;
        for(char c : s.toCharArray()){
            if(cur.children[c-'a'] == null){
                cur.children[c-'a'] = new Trie();
                cur = cur.children[c-'a'];
            }else{
                cur = cur.children[c-'a'];
            }
            cur.cnt++;
        }
        
    }
}


class Trie{

    Trie[] children = new Trie[26];
    int cnt;
    Trie root;
}