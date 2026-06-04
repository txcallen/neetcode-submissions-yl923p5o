class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        Map<Character, Integer> map = new HashMap<>();

        int priority = 0;
        for(char c : order.toCharArray()){
            map.put(c, priority++);
        }


        for(int i = 0; i < words.length-1; i++){
            String w1 = words[i];
            String w2 = words[i+1];

            if(w1.length() > w2.length() && w1.startsWith(w2)){
                return false;
            }

            for(int j = 0; j < Math.min(w1.length(), w2.length()); j++){
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);

                if(c1 == c2) continue;
                
                int p1 = map.get(c1);
                int p2 = map.get(c2);
                if(p1 > p2){
                    return false;
                }
                break;
            }
        }

        return true;
    }
}