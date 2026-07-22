class Solution {
    public boolean[] findAnswer(int n, int[][] edges) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];

            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }

        long[] fromSrc = dijkstra(adj, 0, n);
        long[] fromDest = dijkstra(adj, n - 1, n);

        boolean[] ans = new boolean[edges.length];
        long shortest = fromSrc[n-1];

       
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            if (fromSrc[u] != Long.MAX_VALUE &&
                 fromDest[v] != Long.MAX_VALUE &&
                fromSrc[u] + w + fromDest[v] == shortest) {
                 ans[i] = true;
            } 

            if (fromSrc[v] != Long.MAX_VALUE &&
                fromDest[u] != Long.MAX_VALUE &&
                fromSrc[v] + w + fromDest[u] == shortest) {
                ans[i] = true;
             }
        }
        return ans;
    }

    public long[] dijkstra(ArrayList<ArrayList<int[]>> adj, int src, int n) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0],b[0]));
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;
        pq.offer(new long[]{0, src});

        while(!pq.isEmpty()) {
            long[] curr = pq.poll();

            long currDist = curr[0];
            int node = (int) curr[1];

            if(currDist>dist[node]) {
                continue;
            }

            for(int[] edge : adj.get(node)) {
                int neighbour = edge[0];
                int wt = edge[1];

                if(dist[neighbour]>currDist+wt) {
                    dist[neighbour]=currDist+wt;
                    pq.offer(new long[]{dist[neighbour],neighbour});
                }
            }
        }
        return dist;
    }
}