class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int operations = 0;
        int i=0;
        int count1seen =0;

        while(i<n) {

            if(s.charAt(i)=='0'){
                 operations+=count1seen;
                 while(i<n && s.charAt(i)=='0'){
                    i++;
                 }
            }
            else{
                count1seen++;
                i++;
            }
        }
          return operations;
    }
}