class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        boolean[] sus = new boolean[n];
        int[] indegree = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : invocations) {
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        sus[k] = true;

        while(!queue.isEmpty()) {
            int curr=queue.poll();

            for(int ngbr : adj.get(curr)){
                indegree[ngbr]--;
                if(!sus[ngbr]){
                    sus[ngbr]=true;
                    queue.offer(ngbr);
                }
            }
        }
          
          boolean all = false;
        for(int i=0;i<n;i++) {
            if(sus[i] && indegree[i]>0) {
                all=true;
                break;
            }
            if(!sus[i]){
               result.add(i);
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        if(all){
            for(int i=0;i<n;i++){
              ans.add(i);
            }

            return ans;
        }

        return result;
    }
}