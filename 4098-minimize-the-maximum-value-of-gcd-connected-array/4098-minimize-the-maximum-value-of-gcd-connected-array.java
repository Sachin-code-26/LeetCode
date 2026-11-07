class Solution {
    public long minimumMaxValue(int n, int index, int value) {

        int p = value;

        for(int i=2; i*i<=value;i++) {
            if(value % i == 0) {
                p=i;
                break;
            }
        }

        if(value==1) {
            return -1;
        }


        if(index>0) {
            if(p==value) {
                return -1;
            }

            if((long) value - p < 2L * index) {
                return -1;
            }
        }

        int right = n-index-1;

        if(right==0) {
            return value;
        }

        return (long) value + p + 2L * (right-1);
    }
}