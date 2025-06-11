/*

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109

*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        // We cannot obtain a sum of target if the smallest value
        // in nums is greater than target / k or if the largest
        // value in nums is smaller than target / k.
        long average_value = target / 4;
        if (nums[0] > average_value || average_value > nums[nums.length - 1]) {
            return ansList;
        }
        for (int first = 0; first < nums.length-3; first++) {
            if (first > 0 && nums[first] == nums[first-1]) {
                continue;
            }
            threeSum(nums, ansList, first, target);
        }
        return ansList;
    }
    public List<List<Integer>> threeSum(int[] nums, List<List<Integer>> ansList, int first, long target) {
        for (int i = first+1; i < nums.length-2; i++) {
            if (i > first+1 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                long sum = nums[first] + nums[i] + nums[j] + nums[k];
                if (sum < target) {
                    j++;
                }
                else if (sum > target) {
                    k--;
                }
                else if (sum == target) {
                    ansList.add(Arrays.asList(nums[first], nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k+1]) {
                        k--;
                    }
                }
            }
        }
        return ansList;
    }
}
