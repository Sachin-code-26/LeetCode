class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n];
        for(int i=0;i<relations.length;i++){
            int u=relations[i][0]-1;
            int v=relations[i][1]-1;
            adj.get(u).add(v);
            indegree[v]++;
        }
         int[] maxtime = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
           if(indegree[i]==0){
            queue.add(i);
            maxtime[i]=time[i];
           }
       }
       
      
      
       while(!queue.isEmpty()) {
         int curr = queue.poll();
         
          for(int neigh: adj.get(curr)){
            indegree[neigh]--;
            maxtime[neigh]=Math.max(maxtime[neigh],(maxtime[curr]+time[neigh]));
            if(indegree[neigh]==0) {
                queue.add(neigh);
            }
          }
       }
       
       int max=0;
       for(int ele : maxtime) {
          max=Math.max(max,ele);
       }

       return max;
    }
}