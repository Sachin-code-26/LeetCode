class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int ele: nums){
            set.add(ele);
        }
        int n=nums.length;
        Arrays.sort(nums);
        int smallest=nums[0];
        int largest = nums[n-1];

        for(int i=smallest;i<=largest;i++) {
            if(!set.contains(i)){
                list.add(i);
            }
        }


      return list;
    }
}