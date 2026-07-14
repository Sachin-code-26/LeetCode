class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] sortedArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortedArr);
        
        int rank=1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : sortedArr) {
            if(!map.containsKey(ele)){
                map.put(ele,rank);
                rank++;
            }
        }
        
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i]=map.get(arr[i]);
        }

        return res;
    }
}