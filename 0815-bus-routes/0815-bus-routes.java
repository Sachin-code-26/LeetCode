class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int route=0;route<routes.length;route++) {
            for(int stop : routes[route]) {
                adj.computeIfAbsent(stop, k -> new ArrayList<>()).add(route);
            }

        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[routes.length];
        if (!adj.containsKey(source)) {
            return -1;
        }
        for(int route: adj.get(source)){
            queue.offer(route);
            visited[route]=true;
        }

        int busCount=1;

        while(!queue.isEmpty()) {
            int size= queue.size();

            while(size--> 0) {
                int route =queue.poll();

                for (int stop : routes[route]) {
                    if(stop==target){
                        return busCount;
                    }

                    // if (!adj.containsKey(stop)) {
                    //     continue;
                    // }


                    for(int nextRoute : adj.get(stop)){
                        if(!visited[nextRoute]){
                            queue.offer(nextRoute);
                            visited[nextRoute] = true;
                        }
                    }
                }
            }
            busCount++;
        }

        return -1;
    }
}