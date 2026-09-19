class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int i=0;
        int j=0;
        StringBuilder sb = new StringBuilder();
        while(i<m && j<n){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
            i++;
            j++;
        }

        if(i==m){
            sb.append(word2.substring(j));
        }

        if(j==n){
            sb.append(word1.substring(i));
        }

        return sb.toString();
    }
}