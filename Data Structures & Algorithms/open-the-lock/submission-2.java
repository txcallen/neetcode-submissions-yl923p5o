class Solution {
    public int openLock(String[] deadends, String target) {
        
        if("0000".equals(target)){
            return 0;
        }

        Set<String> dead = new HashSet<>();
        for(String s : deadends){
            dead.add(s);
        }

        if(dead.contains("0000")){
            return -1;
        }

        Queue<String> que = new LinkedList<>();
        que.offer("0000");

        int stp = 0;
        while(!que.isEmpty()){
            
            int size = que.size();
            while(size-- > 0){
                String cur = que.poll();
                if(target.equals(cur)){
                    return stp;
                }
                char[] arr = cur.toCharArray();
                dead.add(cur);
                for(int i = 0; i < cur.length(); i++){
                    char c = cur.charAt(i);
                    int cn = (int) c-1;
                    if(cn < '0'){
                        cn = '9';
                    }
                    char[] minus = cur.toCharArray();
                    minus[i] = (char)cn;
                    String newMinus = new String(minus);

                    if(dead.add(newMinus)){
                        que.offer(newMinus);
                    }

                    c = cur.charAt(i);
                    int cn2 = (int)c + 1;
                    if(cn2 > '9'){
                        cn2 = '0';
                    }

                    char[] plus = cur.toCharArray();
                    plus[i] = (char)cn2;
                    String newPlus = new String(plus);

                    if(dead.add(newPlus)){
                        que.offer(newPlus);
                    }
                }
            }
            stp++;
        }

        return -1;
    }
}