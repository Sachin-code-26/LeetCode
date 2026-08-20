class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> arr1= new ArrayList<>();
        ArrayList<Integer> arr2= new ArrayList<>();
        int n=nums.length;
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for(int i=2;i<n;i++){
            if(arr1.get(arr1.size()-1)>arr2.get(arr2.size()-1)){
                arr1.add(nums[i]);
            }
            else{
                arr2.add(nums[i]);
            }
        }
        
        int size=arr1.size()+arr2.size();

        arr1.addAll(arr2);
        
        int[] res = new int[n];
        for(int i=0;i<size;i++){
           res[i]=arr1.get(i); 
        }

        return res;
    }
}