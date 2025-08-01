/*

Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

 

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.
Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1

*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //in-place sorting
        for (int i = 0; i < n; i++) {
            if (nums[i] < 1 || nums[i] > n) {
                continue;
            }
            int bkp = nums[nums[i]-1];
            nums[nums[i]-1] = nums[i];
            while (bkp > 0 && bkp <= n && nums[bkp-1] != bkp) {
                int bkp2 = nums[bkp-1];
                nums[bkp-1] = bkp;
                bkp = bkp2;
            }
        }
        //check if 1 is missing or not
        if (nums[0] != 1) {
            return 1;
        }
        //check if its missing from 1 to n range
        for (int i = 0; i < n-1; i++) {
            if (nums[i+1] - nums[i] != 1) {
                return nums[i] + 1;
            }
        }
        //return if nothing is missing from range 1 to n
        return n + 1;
    }
}
