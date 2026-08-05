class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n;
    public List<List<Integer>> subsets(int[] nums) {
       n = nums.length;
       List<Integer> temp = new ArrayList<>();
       solve(temp,0,nums);
       return result;
    }

    public void solve(List<Integer> temp , int idx, int[] nums) {
        
        if(idx>=n){
            result.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[idx]);
        solve(temp,idx+1,nums);
        temp.remove(temp.size()-1);
        solve(temp,idx+1,nums);
    }
}