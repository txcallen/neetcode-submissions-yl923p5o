class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        

        dfs(s, 0, new ArrayList<>());
        return res;
    }


    void dfs(String s, int idx, List<String> list){
        if(idx >= s.length()){
            if(!list.isEmpty()){
                res.add(new ArrayList<>(list));
            }
        }

        for(int i = idx+1; i <= s.length(); i++){
            String sub = s.substring(idx, i);
            if(isValid(sub)){
                list.add(sub);
                dfs(s, i, list);
                list.remove(list.size()-1);
            }
        }
    }

    boolean isValid(String s){
        int left = 0, right = s.length()-1;

        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }

        return true;
    }
}
