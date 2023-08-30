class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
            Possible Solution 1:
            Prefix Array * Suffix Array - Runtime O(N), Memory O(N)
            1. initialize int[] prefix, and int[] suffix.
            2. prefix[i] = nums[i-1] * prefix[i-1]; 
            3. suffix[i] = nums[i+1] * suffix[i+1];
            4. prefix[i] is every value multiplied to the left excluding prefix[i];
            5. suffix[i] is every value multiplied to the right excluding suffix[i];
            6. ans[i] = prefix[i] * suffix[i] 

            Possible Solution 2:
            Fill answer array with prefix and then suffix - Runtime O(N), Memory O(N)
            1. initialize curr = 1;
            2. fill ans array with 1 (java initializes array with 0)
            3. ans[i] *= curr (prevNum (to the left/right));
            4. curr *= nums[i] (nextNum(to the left/right));
            5. repeat for suffix
        */
        int n  = nums.length;
        int curr = 1;
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);

        for (int i = 0; i < n; i++){
            ans[i] *= curr;
            curr *= nums[i];
        }

        curr = 1;
        for (int i = n - 1; i >= 0; i--){
            ans[i] *= curr;
            curr *= nums[i];
        }
        return ans;
    }

}