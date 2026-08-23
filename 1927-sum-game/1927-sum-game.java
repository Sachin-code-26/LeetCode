class Solution {
    public boolean sumGame(String num) {
        int n=num.length();
        int nq=0;
        for(int i=0;i<n;i++){
            if(num.charAt(i) == '?'){
                nq++;
            }
        }
        if(nq%2==1) return true;
        int nql=0,nqr=0,sl=0,sr=0;
        for(int i=0;i<n;i++){
            if(i<n/2){
                if(num.charAt(i)=='?'){
                    nql++;
                }
                else{
                    sl+=(num.charAt(i)-'0');
                }
            }
            else{
                if(num.charAt(i)=='?'){
                    nqr++;
                }
                else{
                    sr+=(num.charAt(i)-'0');
                }
            }
        }
        if( ((9*nql)+(2*sl)) == ((9*nqr)+(2*sr)) ) return false;
        return true;
    }
}