class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int length = nums.length;
        int left = 0, right = length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;
            else if (target <= nums[length - 1]) 
            {
                if (nums[mid] <= nums[length - 1]) 
                {
                    if (nums[mid] < target) left = mid;
                    else right = mid;
                } 
                else left = mid;
            } 
            else 
            {
                if (nums[mid] <= nums[length - 1]) right = mid;
                else 
                {
                    if (nums[mid] < target) left = mid;
                    else right = mid;
                }
            }
        }

        if (nums[right] == target) return right;
        else if (nums[left] == target) return left;
        else return -1;
    }
}