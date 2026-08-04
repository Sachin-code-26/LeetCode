class Solution {
    int n;
    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        ArrayList<Integer> temp = new ArrayList<>();
        solve(temp,nums);

        return result;
    }

    public void solve(ArrayList<Integer> temp, int[] nums) {
        if(temp.size()==n){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<n;i++){

          if(!set.contains(nums[i])){
            set.add(nums[i]);
            temp.add(nums[i]);
            solve(temp,nums);
            set.remove(nums[i]);
            temp.remove(temp.size()-1);
            
             }
        }
           
    }
}