class Solution {

    List<String> result = new ArrayList<>();
    int n;
    public List<String> letterCombinations(String digits) {
        n = digits.length();
        if(digits.length() == 0) {
            return new ArrayList<>();
        }

        Map<Character, String> map = new HashMap<>();

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        
       StringBuilder temp = new StringBuilder();

        solve(0,digits,map,temp);

        return result;
    }

    public void solve(int idx , String digits , Map<Character, String> map , StringBuilder temp ) {

        if(idx>=n){
            result.add(temp.toString());
            return ;
        }

        char ch =digits.charAt(idx);
        String str = map.get(ch);

        for(int i=0;i<str.length();i++) {
            temp.append(str.charAt(i));
            solve(idx+1,digits,map,temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}