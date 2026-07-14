class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length;
      Arrays.sort(g);
      Arrays.sort(s);
      int l=0;
      int r=s.length;
      int count=0;
      for(int i=0;i<n && l<r;) {
        if(s[l]>=g[i]){
            count++;
            l++;
            i++;
        }
        else{
        l++;
        }
      }
       
       return count;
    }
}