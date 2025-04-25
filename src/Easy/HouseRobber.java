/*

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400

*/

class Solution {
    public int rob(int[] nums) {
        boolean canRob = true;
        return Math.max(helper(nums, 0, canRob, 0), helper(nums, 1, canRob, 0));
    }

    public int helper(int[] nums, int index, boolean canRob, int sum) {
        if (index >= nums.length) {
            return sum;
        }
        if (!canRob) {
            canRob = true;
            return Math.max(helper(nums, index, canRob, sum), helper(nums, index+1, canRob, sum));
        }
        if (index < nums.length-3 && nums[index+3] > nums[index+2]) {
            canRob = false;
        }
        sum = sum + nums[index];
        return helper(nums, index + 2, canRob, sum);
    }
}

// Using simple DP and Memoization

class SolutionDP {
    int[] nums;
    Map<Integer, Integer> memo = new HashMap<>();
    public int rob(int[] nums) {
        this.nums = nums;
        return dp(nums.length-1);
    }
    
    public int dp(int i) {
        if(i == 0) {
            return nums[0];
        }
        if(i == 1) {
            return Math.max(nums[1], nums[0]);
        }
        if (!memo.containsKey(i)) {
            memo.put(i, Math.max(dp(i-2) + nums[i], dp(i-1)));
        }
        return memo.get(i);
    }
}
