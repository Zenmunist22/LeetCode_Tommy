class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
            Solutions
            -- Sort first, then count (n log n)
            -- freq count -> keep a heap (n log n)( due to heap )
            -- freq count into a bucket (n)
        */

        // Count the frequency of appearances, store as k,v (unique number, freq)
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        
        // Create an array of lists, where the array is of size nums(possible freq is 1 for each occurance), then each list will contain the original value
        // bucket is nums.length+1, where the list size inside bucket should be 1 (the key)
        List<Integer>[] bucket = new List[nums.length+1];
        for (int i : hm.keySet()){
            if (bucket[hm.get(i)] == null){
                bucket[hm.get(i)] = new ArrayList<>();
            }
            bucket[hm.get(i)].add(i);
        } 

        // Count backward, break when k is reached, as the back of the bucket is more frequent than the front of the bucket
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length-1; i >= 0; i--){

            if (bucket[i] != null){
                res.addAll(bucket[i]);
            }
            
            if (res.size() >= k){
                break;
            }
        }
        return res.stream().mapToInt(i->i).toArray();

    }
}