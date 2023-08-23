class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
            Idea is utilizing the array and calculating prefix/suffix
            1. Can use two additional arrays to store left & right 
                - (left[i] = left[i - 1] * nums[i - 1]) 
                - (right[i] = right[i + 1] * nums[i + 1])
                - then multiply left[i] and right[i] to create the res[i]
            2. for o(1) space complexity, we can store the "curr" left and multiply it through the array, then proceed with the right. which is implemented below for o(n) runtime

        */
        int res[] = new int[nums.length];
        int curr = 1;

        Arrays.fill(res, 1);
        
        for (int i = 0; i < nums.length; i++){
            res[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            res[i] *= curr;
            curr *= nums[i];
        }

        return res;

    }
}