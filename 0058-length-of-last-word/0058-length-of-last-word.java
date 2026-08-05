class Solution {
    public int lengthOfLastWord(String s) {
        StringBuilder st=new StringBuilder(s.trim());
        int len=st.length();
        int count=0;
        for(int i=len-1;i>=0;i--){
            if(st.charAt(i)==' '){
                break;
            }
            count++;
        }

        return count;
    }
}