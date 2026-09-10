class Solution {
    HashMap<String, Boolean> mp = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        mp.clear();
        return solve(s1,s2);
    }

    public boolean solve(String s1 , String s2) {

        int n = s1.length();

        if(s1.equals(s2)) {
            return true;
        }

        if(s1.length()!=s2.length()) {
            return false;
        }

        String key = s1 + "_" + s2;

        if (mp.containsKey(key)) {
            return mp.get(key);
        }

        boolean result = false;

        for(int i=1;i<n;i++) {
            /*
                swapped case
                s1="great", s2 = "eatgr"

                    i=2
                    
                solve(s1.substring(0,i),s2.substring(n-i)
                && solve(s1.substring(n-i),s2.substring(0,n-i)
            */

            boolean swapped = solve(s1.substring(0,i),s2.substring(n-i))
                && solve(s1.substring(i),s2.substring(0,n-i));

                if (swapped) {
                result = true;
                break;
            }

                /*
                not swapped case
                s1="great", s2 = "great"

                    i=2
                    
                solve(s1.substring(0,i),s2.substring(0,i)
                && solve(s1.substring(i),s2.substring(i);
            */

            boolean notSwapped =
                    solve(s1.substring(0, i), s2.substring(0, i))
                    &&
                    solve(s1.substring(i), s2.substring(i));
        

         if (notSwapped) {
                result = true;
                break;
            }
    }

    mp.put(key, result);

        return result;
    }
}