class Solution {
    public String smallestSubsequence(String s) {
       
        int[] lastIdx= new int[26];
        boolean[] taken = new boolean[26];

        for(int i=0;i<s.length();i++) {
            char ch=s.charAt(i);
            lastIdx[ch-'a']=i;
        }

        StringBuilder res = new StringBuilder();

        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(taken[c-'a']==true) {
                continue;
            }
           
            while(res.length()>0 && res.charAt(res.length()-1) > c && lastIdx[res.charAt(res.length()-1)-'a']>i){
               char removed = res.charAt(res.length() - 1);
                taken[removed - 'a'] = false;
                res.deleteCharAt(res.length() - 1);
            }
            res.append(c);
            taken[c-'a']=true;


        }
        return res.toString();
    }
}