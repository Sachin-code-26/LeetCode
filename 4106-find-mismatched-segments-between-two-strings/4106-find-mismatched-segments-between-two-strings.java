class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> ans = new ArrayList<>();
        int n = s1.length();
         int i=0;
        while (i<n) {

             if(s1.charAt(i)!=s2.charAt(i)){
                 StringBuilder sb1 = new StringBuilder();
                 StringBuilder sb2 = new StringBuilder();
                 while(i<n && s1.charAt(i)!=s2.charAt(i)) {
                     sb1.append(s1.charAt(i));
                     sb2.append(s2.charAt(i));

                     i++;
                 }

                 List<String> list = new ArrayList<>();
                 
                list.add(sb1.toString());
                list.add(sb2.toString());
                ans.add(list);
            } else {
                 i++;
            }
            
        }

        return ans;
    }
}