class Solution {
    LinkedList<String> res = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, Queue<String>> graph = new HashMap<>();

        for(List<String> ticket : tickets){
            String start = ticket.get(0);
            String end = ticket.get(1);
            graph.computeIfAbsent(start, k -> new PriorityQueue<>()).offer(end);
        }

        dfs("JFK", graph);

        return res;
    }


    void dfs(String start, Map<String, Queue<String>> graph){
        Queue<String> que = graph.getOrDefault(start, new LinkedList<>());
        while(!que.isEmpty()){
            dfs(que.poll(), graph);
        }
        res.addFirst(start);
    }
}
