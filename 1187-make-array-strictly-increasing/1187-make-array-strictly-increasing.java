class Solution {
    int n;
    HashMap<String, Integer> mp = new HashMap<>();
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        n = arr1.length;
        mp.clear();
        Arrays.sort(arr2);

       int result = solve(0,arr1,arr2,Integer.MIN_VALUE);

       return result==(int)1e9+1?-1:result;
    }

    public int solve(int i, int[] arr1, int[] arr2, int prev) {
        if(i>=n){
            return 0;
        }

        String key = i + "_" + prev;

        if(mp.containsKey(key)){
            return mp.get(key);
        }

        int result1 = (int)1e9+1;
        int result2 = (int)1e9+1;

        if(arr1[i]>prev){
            result1 = solve(i+1, arr1, arr2 , arr1[i]);
        }

        int idx = upperBound(arr2,prev);

        if(idx<arr2.length){
            result2 = 1+solve(i+1,arr1,arr2,arr2[idx]);

        }
        int ans = Math.min(result1,result2);
        mp.put(key,ans);

        return ans;
    }

    public int upperBound(int[] arr2, int target){
        
        int left = 0;
        int right = arr2.length;

        while(left<right){
            int mid = left+(right-left)/2;

            if(arr2[mid]<=target){
                left  = mid+1;
            }
            else{
                right = mid;
            }    
        }
        return left;
    }
}