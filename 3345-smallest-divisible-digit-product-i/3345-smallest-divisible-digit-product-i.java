class Solution {
    public int smallestNumber(int n, int t) {
        int start=n;
       
        int num =  findProduct(n);
       while((num%t)!=0) {
           n++;
          num =  findProduct(n);
        
       }
       return n;
    }

    public int findProduct(int n){
        int prod=1;
        while(n>0){
            int r=n%10;
             prod=prod*r;
            n=n/10;
        }
        return prod;
    }
}