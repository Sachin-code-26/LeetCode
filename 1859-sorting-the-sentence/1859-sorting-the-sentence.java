class Solution {
    public String sortSentence(String s) {
        
        String[] words = s.split(" ");
        String[] arr = new String[words.length];

        for(int i=0;i<words.length;i++) {
            String word = words[i];
            int pos = word.charAt(word.length()-1)-'0';
            arr[pos - 1] = word.substring(0, word.length() - 1);
        }
        return String.join(" ", arr);
    }
}