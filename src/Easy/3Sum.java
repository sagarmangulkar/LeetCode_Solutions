/*

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105

*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                twoSum(i, nums, ans);
            }
        }
        return ans;
    }

    public void twoSum(int firstIndex, int[] nums, List<List<Integer>> ans) {
        int low = firstIndex+1;
        int high = nums.length-1;
        while (low < high) {
            int sum = nums[firstIndex] + nums[low] + nums[high];
            if (sum < 0) {
                low++;
            }
            else if (sum > 0) {
                high--;
            }
            else {
                ans.add(Arrays.asList(nums[firstIndex], nums[low], nums[high]));
                low++;
                high--;
                while (low < high && nums[low] == nums[low-1]) {
                    low++;
                }
            }
        }
    }
}


//Second practice

class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        //[-4,-1,-1,0,1,2]
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int low = i+1;
            int high = nums.length-1;
            while (low < high) {
                if (low > i+1 && nums[low] == nums[low-1]) {
                    low++;
                    continue;
                }
                if (high < nums.length-1 && nums[high] == nums[high+1]) {
                    high--;
                    continue;
                }
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[low]);
                    triplet.add(nums[high]);
                    ans.add(triplet);
                }
                if (sum > 0) {
                    high--;
                }
                else {
                    low++;
                }
            }
        }
        return ans;
    }
}
