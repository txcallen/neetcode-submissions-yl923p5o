class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, List<Pair<String, Double>>> map = new HashMap<>();

        for(int i = 0; i < equations.size(); i++){
            List<String> list = equations.get(i);
            String start = list.get(0);
            String end = list.get(1);

            map.computeIfAbsent(start, k -> new ArrayList<>()).add(new Pair(end, values[i]));
            map.computeIfAbsent(end, k -> new ArrayList<>()).add(new Pair(start, (double)1.0 / values[i]));
        }

        List<Double> res = new ArrayList<>();

        for(List<String> q : queries){
            String start = q.get(0);
            String end = q.get(1);

            if(start.equals(end) && map.containsKey(start)){
                res.add(1.0);
                continue;
            }
            Queue<Pair<String, Double>> que = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            que.offer(new Pair(start, 1.0));
            boolean found = false;

            if(!map.containsKey(start) || !map.containsKey(end)){
                res.add(-1.0);
                continue;
            }
            while(!que.isEmpty()){
                Pair<String, Double> cur = que.poll();
                String curKey = cur.getKey();
                Double curVal = cur.getValue();
                if(!map.containsKey(curKey)){
                    res.add(-1.0);
                    break;
                }
                if(end.equals(curKey)){
                    res.add(curVal);
                    found = true;
                    break;
                }

                visited.add(curKey);

                
                for(Pair<String, Double> next : map.get(curKey)){
                    String nextKey = next.getKey();
                    Double nextVal = next.getValue();
                    if(!visited.contains(nextKey)){
                        que.offer(new Pair(nextKey, curVal * nextVal));
                    }
                }

            }

            if(!found){
                res.add(-1.0);
            }
        }

        return res.stream().mapToDouble(d -> d).toArray();
    }
}

// class Pair<K, V> {
//     K key;
//     V value;

//     Pair(K k, V v) {
//         key = k;
//         value = v;
//     }

//     K getKey() { return key; }
//     V getValue() { return value; }
// }