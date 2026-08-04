class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(0,target,temp,result,candidates);

        return result;
    }

    public void solve(int idx , int target, List<Integer> temp, List<List<Integer>> result , int[] candidates){
        if(target==0){
           result.add(new ArrayList<>(temp));
           return;
        }

        if (target < 0 || idx == candidates.length) {
            return;
        }

        temp.add(candidates[idx]);
        solve(idx,target-candidates[idx],temp, result,candidates);
        temp.remove(temp.size()-1);
        //skip the curr ele
        solve(idx+1,target,temp, result,candidates);

    }
}