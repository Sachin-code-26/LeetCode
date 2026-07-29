class Solution {
    public boolean squareIsWhite(String coordinates) {
        char alpha=coordinates.charAt(0);
        char num=coordinates.charAt(1);

        if ((alpha == 'a' || alpha == 'c' || alpha == 'e' || alpha == 'g') && num % 2 == 0) {
           return true;
        }
        else if((alpha=='b' || alpha =='d' || alpha=='f' || alpha =='h') && num%2!=0){
            return true;
        }
        return false;
    }
}