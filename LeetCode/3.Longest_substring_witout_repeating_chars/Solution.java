class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128]; 
        Arrays.fill(lastSeen, -1);
        int maxLength = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            left = max(left, lastSeen[c] + 1);
            maxLength = max(maxLength, i - left + 1);
            lastSeen[c] = i;
        }
        return maxLength;
    }

    private int max(int a,int b){
        return (a>b)?a:b;
    }
}
