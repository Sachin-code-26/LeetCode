class Solution {
    public String truncateSentence(String s, int k) {
        String[] words = s.split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<k;i++) {
            sb.append(words[i]+" ");
        }

        return sb.substring(0,sb.length()-1).toString();
    }
}