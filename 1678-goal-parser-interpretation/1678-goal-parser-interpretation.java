class Solution {
    public String interpret(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) {
            if(s.charAt(i)=='G') {
                sb.append('G');
            }
            else if(s.charAt(i)=='(' && s.charAt(i+1)==')'){
                sb.append('o');
                i+=1;
            }
            else if(s.charAt(i)=='(' && s.charAt(i+1)=='a'){
                sb.append("al");
                i+=3;
            }
        }

        return sb.toString();
    }
}