class Solution {
    public boolean rotateString(String s, String goal) {
        int m =s.length();
        int n =goal.length();

        if(m!=n){
            return false;
        }
        
        for(int i=0;i<m;i++){
            String t =s.substring(i) + s.substring(0,i);

            if(t.equals(goal)){
                return true;
            }
        }

        return false;
    }
}