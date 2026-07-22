class Solution {
    public int minCost(int n, int[][] edges) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];

            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,2*wt});
        }

        long[] dist=dijkstra(adj,0,n);

        return (int)dist[n-1];
    }


    public long[] dijkstra(ArrayList<ArrayList<int[]>> adj , int src, int n) {
        
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0,src});

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();

            int currDist=curr[0];
            int node=curr[1];

            if(currDist>dist[node]) {
                continue;
            }

            for(int[] edge: adj.get(node)) {

                int neigh=edge[0];
                int wt=edge[1];

                if(currDist+wt < dist[neigh]) {
                    dist[neigh] = currDist+wt;
                    pq.offer(new int[]{currDist+wt,neigh});
                }
            }
        }

        return dist;
    }
}