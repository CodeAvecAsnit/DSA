class Solution{
//First Approach
    public static int[] twoSum(int[] num,int target){
        int[] data=new int[2];

	for(int i=0;i<num.length;++i){
            for(int j=i+1;j<num.length;++j){
                if(num[i]+num[j]==target){
                    data[0]=i;
                    data[1]=j;
                }
            }

        }
        return data;
    }

// best approach
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length;++i){
            map.put(nums[i],i);
        }
        for(int i = 0 ; i < nums.length;++i){
            int currTar = target - nums[i];
            if(map.containsKey(currTar) && map.get(currTar) != i){
                return new int[]{i,map.get(currTar)};
            }
        }
        return new int[]{};
    }
}

