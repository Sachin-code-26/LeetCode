class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        shifts[n-1]=shifts[n-1]%26;
        for(int j=n-2;j>=0;j--){
            shifts[j]=(shifts[j]+shifts[j+1]) % 26;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            sb.append((char)('a' +(ch-'a' + shifts[i]) % 26));
        }

        return sb.toString();
    }
}