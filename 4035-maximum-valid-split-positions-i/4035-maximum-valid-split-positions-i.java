class Solution {
    
    public int maxValidSplits(int[] nums) {
        int n = nums.length;
        int ans= 0;

        for(int remove=-1;remove<n;remove++){
            int[] arr = new int[remove==-1?n:n-1];

            int j=0;
            for(int i = 0;i<nums.length;i++){
                if(i!=remove){
                    arr[j++]=nums[i];
                }
            }

            ans = Math.max(ans,countSplits(arr));
        }

        return ans;
    }

    // public int countSplits(int[] arr) {
    //     int count=0;

    //     //try every split

    //     for(int i=0;i<arr.length-1;i++)
    //     {
    //     //left
    //     int leftGcd = arr[0];
    //     for(int j=1;j<=i;j++){
    //          leftGcd=gcd(leftGcd,arr[j]);
    //     }

    //     //right
    //     int rightGcd=arr[i+1];
    //     for(int j=i+2;j<arr.length;j++){
    //         rightGcd = gcd(rightGcd, arr[j]);
    //     }

    //     if(leftGcd == rightGcd){
    //         count++;
    //      }
    //     }
    //     return count;
    // }


    public int countSplits(int[] arr){
        int count =0;
        int n = arr.length;
        int[] suffix = new int[arr.length];

        suffix[n-1]=arr[n-1];

        for(int i=n-2;i>=0;i--){
            suffix[i] = gcd(arr[i],suffix[i+1]);
        }

        //try every split
        int leftGcd=0;
        for(int i=0;i<n-1;i++){
            leftGcd= gcd(leftGcd,arr[i]);

            if(leftGcd==suffix[i+1]){
                count++;
            }
        }

        return count;
    }


    public int gcd(int a , int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a%b);
    }

}