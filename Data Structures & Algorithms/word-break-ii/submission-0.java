class Solution {
    Set<String> set = new HashSet<>();

    List<String> res = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        set.addAll(wordDict);    
        backtrack(s, 0, new ArrayList<>());
        return res;
    }

    void backtrack(String s, int idx, List<String> list){
        if(idx >= s.length()){
            res.add(String.join(" ", list));
            return;
        }

        for(int j = idx; j < s.length(); j++){
            String sub = s.substring(idx, j+1);
            if(set.contains(sub)){
                list.add(sub);
                backtrack(s, j+1, list);
                list.remove(list.size()-1);
            }
        }
    }
}