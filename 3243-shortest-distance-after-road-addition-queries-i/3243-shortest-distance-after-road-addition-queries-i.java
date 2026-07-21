class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<=n-2;i++){
            adj.get(i).add(i+1);
        }
        int[] res = new int[queries.length];
        int idx=0;
        for(int[] query : queries){
            int u=query[0];
            int v=query[1];

            adj.get(u).add(v);

            int d=bfs(adj,n);
            res[idx++]=d;
        }

        return res;
    }

    public int bfs(ArrayList<ArrayList<Integer>> adj , int n) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        boolean[] visited = new boolean[n];
        visited[0] = true;
        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();

            while(size-->0) {
                int node =queue.poll();

                if(node == n-1) {
                    return level;
                }

                for(int neigh: adj.get(node)) {
                    if(!visited[neigh]){
                        visited[neigh]=true;
                        queue.offer(neigh);
                    }
                }
            }
            level++;
        }

        return -1;
    }
}