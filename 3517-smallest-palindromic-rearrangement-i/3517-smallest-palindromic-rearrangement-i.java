class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        String str=s.substring(0,n/2);

        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(new String(arr));

        if(n%2==1){
            sb.append(s.charAt(n/2));
        }

        for(int i=arr.length-1;i>=0;i--) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}