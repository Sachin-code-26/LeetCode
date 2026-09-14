class Solution {
    int n;
    int[] dp;
    public int maxScore(int[] nums) {
        n = nums.length;
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        boolean[] visited = new boolean[n];
        HashMap<String,Integer> map = new HashMap<>();

        return solve(1,nums,visited,map);
    }

    public int solve(int operations, int[] nums, boolean[] visited , HashMap<String,Integer> map) {

        String key = getKey(visited);

        if(map.containsKey(key)){
            return map.get(key);
        }

        int maxScore = 0;
        for(int i=0;i<n;i++){
           
            if(visited[i]){
                continue;
            }

            for(int j=i+1;j<n;j++) {
                if(visited[j]){
                    continue;
                }

                int score = operations * gcd(nums[i],nums[j]);
                visited[i] = true;
                visited[j] = true;
                int rem_score = solve(operations+1,nums,visited,map);
                maxScore = Math.max(maxScore,score+rem_score);
                visited[i]= false;
                visited[j] = false;

            }
        }

        map.put(key,maxScore);
        return  maxScore;
    }

    public int gcd(int a, int b) {
        if(b==0){
            return a;
        }

        return gcd(b,a%b);
    }

    public String getKey(boolean[] visited) {
        StringBuilder sb = new StringBuilder();

        for(boolean b: visited){
            sb.append(b ? '1' : '0');
        }

        return sb.toString();
    }
}