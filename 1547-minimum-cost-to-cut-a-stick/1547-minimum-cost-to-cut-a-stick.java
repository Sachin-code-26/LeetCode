

class Solution {
    
    int[][] t = new int[103][103];

    int solve(int[] cuts, int left, int right) {
        
        if (right - left == 1)
            return 0;
        
        if (t[left][right] != -1)
            return t[left][right];
        
        int result = Integer.MAX_VALUE;
        
        for (int index = left + 1; index <= right - 1; index++) {
            
            int cost = solve(cuts, left, index)
                     + solve(cuts, index, right)
                     + (cuts[right] - cuts[left]);
            
            result = Math.min(result, cost);
        }
        
        return t[left][right] = result;
    }

    int minCost(int n, int[] cuts) {
        
        Arrays.sort(cuts);
        
        int[] newCuts = new int[cuts.length + 2];
        
        newCuts[0] = 0;
        
        for (int i = 0; i < cuts.length; i++) {
            newCuts[i + 1] = cuts[i];
        }
        
        newCuts[cuts.length + 1] = n;
        
        Arrays.fill(t[0], -1);
        for (int i = 1; i < 103; i++) {
            Arrays.fill(t[i], -1);
        }
        
        return solve(newCuts, 0, newCuts.length - 1);
    }
}