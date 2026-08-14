class Solution {
    public int maximumLengthSubstring(String s) {
        int[] arr = new int[26];
        int n = s.length();
        int c=0;
        int maxlength = 0;

        for(int i=0;i<n;i++){
            c=0;
            arr = new int[26];
            for(int j=i;j<n;j++){
               char ch=s.charAt(j);
                arr[ch-'a']++;
                if(arr[ch-'a']>2){
                    break;
                }
                maxlength = Math.max(maxlength, j - i + 1);
            }
        }

        return maxlength;
    }
}