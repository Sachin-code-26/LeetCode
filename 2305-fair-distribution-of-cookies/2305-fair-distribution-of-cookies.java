class Solution {
    int res = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int[] children = new int[k];
        solve(0,cookies,children,k);
        return res;
    }

    public void solve(int idx, int[] cookies, int[] children , int k) {
        if(idx==cookies.length) {
           int max =0;
           for(int child : children) {
            max=Math.max(max,child);
           }

           res=Math.min(res,max);
           return;
        }

        int cookie=cookies[idx];
        for(int i=0;i<k;i++){
            children[i]+=cookie;
            solve(idx+1,cookies,children,k);
            children[i]-=cookie;
        }
    }
}