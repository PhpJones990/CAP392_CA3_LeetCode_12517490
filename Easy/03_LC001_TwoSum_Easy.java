class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashmap = new HashMap<>(); 

        for (int i = 0; i < nums.length; i++) 
        {
            if (hashmap.containsKey(target - nums[i])) 
            {
                int[] result = {i, hashmap.get(target - nums[i])}; 
                return result;
            } 
            else 
            {
                hashmap.put(nums[i], i); 
            }
        } 

        return new int[]{};  
    }
}