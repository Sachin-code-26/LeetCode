class Solution {
    public int maxLength(List<String> arr) {
        String temp = new String();
        
        return solve(0,arr,temp);
    }

    public int solve(int idx , List<String> arr , String temp) {
        int n = arr.size();
        if(idx>=n) {
            return temp.length();
        }

        int take = 0;
        int skip =0;

        if(hasDuplicate(arr.get(idx), temp)){
            skip = solve(idx+1,arr,temp);
        }
        else {
             take = solve(idx+1, arr , temp + arr.get(idx));
             skip = solve(idx+1,arr,temp);
        }
       

       return Math.max(take,skip);
    }

    public boolean hasDuplicate(String s1 , String s2) {
        int[] arr = new int[26];

        for(char ch : s1.toCharArray()) {
            

            if(arr[ch-'a'] > 0) {
                return true;
            }

            arr[ch-'a']++;

            
        }

        for(char ch : s2.toCharArray()) {
             if(arr[ch-'a'] > 0) {
                return true;
            }

        }

        return false;
    }
}