class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele: nums) {
            if(!set.contains(ele) && ele!=0){
                set.add(ele);
            }
        }

        return set.size();
    }
}