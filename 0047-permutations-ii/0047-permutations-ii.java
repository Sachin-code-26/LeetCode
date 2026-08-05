class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int n;
    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> temp = new ArrayList<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        backtrack(temp,map);
        return result;
    }

    public void backtrack(List<Integer> temp , Map<Integer, Integer> map) {
        if(temp.size()==n){
            result.add(new ArrayList<>(temp));
            return ;
        }

      
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num=entry.getKey();
            int count = entry.getValue();

            if(count==0) {
                continue;
            }

            temp.add(num);
            map.put(num,count-1);
            backtrack(temp,map);
            temp.remove(temp.size()-1);
            map.put(num,count);
        }
    }
}