class Solution {
    public int myAtoi(String s) {

        s = s.trim();
        if( s.length() == 0) return 0;

        char[] arr = s.toCharArray();

        int count = (arr[0]=='-')? -1 : 1;
        int number = 0;
        int start = (arr[0]=='+'||arr[0]=='-') ? 1 : 0;

        for(int k = start ; k<arr.length ;++k){
            if(!isNumber(arr[k])){
                break;
            }
            int val = arr[k]-'0';
            if (number > Integer.MAX_VALUE / 10 || (number == Integer.  MAX_VALUE / 10 && val > 7)) {
                return (count == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            number = (number * 10) + val;
        }      
        return count*number; 
    }

    public boolean isNumber(char a) {
        return a >= '0' && a <= '9';
    }
} 
