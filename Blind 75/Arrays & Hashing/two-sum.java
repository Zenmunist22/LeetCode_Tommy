class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            int difference = target - nums[i];
            if (hm.containsKey(difference)){
                return new int[] {hm.get(difference), i};
            }
            else{
                hm.put(nums[i], i);
            }

        }
        return new int[] {0,0};
        
    }
}