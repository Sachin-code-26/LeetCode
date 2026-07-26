class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n;
    public List<List<Integer>> findSubsequences(int[] nums) {
         n = nums.length;
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums , int idx ,  List<Integer> curr) {
        if(curr.size()>1) {
            result.add(new ArrayList<>(curr));
        }

        HashSet<Integer> set = new HashSet<>();
        for(int i=idx;i<n;i++) {
            if((curr.isEmpty() || nums[i] >= curr.get(curr.size() - 1)) && !set.contains(nums[i])) {
                curr.add(nums[i]);
                backtrack(nums, i + 1, curr);
                curr.remove(curr.size() - 1);

                set.add(nums[i]);
            }
        }
    }
}