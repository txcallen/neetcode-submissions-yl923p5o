class Solution {
    public String simplifyPath(String path) {
        
        String[] split = path.split("/");

        System.out.println(Arrays.toString(split));


        Deque<String> dq = new ArrayDeque<>();

        for(String sp : split){
            if(sp.isEmpty() || ".".equals(sp)){
                continue;
            }
            if("..".equals(sp)){
                if(!dq.isEmpty()){
                    dq.pop();
                }
            }else{
                dq.push(sp);
            }
        }
        StringBuilder sb = new StringBuilder();

        while(!dq.isEmpty()){
            sb.insert(0,"/");
            sb.insert(0, dq.pop());
            
        }
        sb.insert(0,"/");

        if(sb.length() > 1){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}