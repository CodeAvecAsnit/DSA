class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }else{
        int k=x;
        int ans=0;
        while(x!=0){
            int r=x%10;
            x=x/10;
            ans=(ans*10)+r;
        }
        if(ans==k){
            return true;
        }else{
            return false;
        }
        }
        
    }
}
