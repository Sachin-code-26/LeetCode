class Solution {
    // int n;
    // int[]dp;
    public int longestSubsequence(int[] arr, int diff) {

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int ele: arr){
            if(!map.containsKey(ele-diff)){
                map.put(ele,1);
            }
            else{
                map.put(ele,map.get(ele-diff)+1);
            }
        }

        int max=0;

        for(int val: map.values()) {
            if(val>max){
                max=val;
            }
        }

        return max;












        // n=arr.length;
        // int ans=0;
        // dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // for(int i=0;i<n;i++){
        //    ans =Math.max(ans,1 + solve(i,diff,arr));
        // }

        // return ans;
    }

    // public int solve(int i, int diff,int[] arr) {
        
    //     if(dp[i]!=-1){
    //         return dp[i];
    //     }
    //     int ans=0;
    //     for(int j=i+1;j<n;j++) {
    //         int prev=arr[i];
    //         int curr=arr[j];
    //         if(curr-prev==diff){
    //             ans=Math.max(ans,1+solve(j,diff,arr));
    //         }
    //     }

    //     return dp[i]= ans;
    // }
}