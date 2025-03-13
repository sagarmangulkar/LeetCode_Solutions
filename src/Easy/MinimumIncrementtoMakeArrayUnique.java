/*

You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.

Return the minimum number of moves to make every value in nums unique.

The test cases are generated so that the answer fits in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,2]
Output: 1
Explanation: After 1 move, the array could be [1, 2, 3].
Example 2:

Input: nums = [3,2,1,2,1,7]
Output: 6
Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown that it is impossible for the array to have all unique values with 5 or less moves.
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105

*/

class Solution {
    public int minIncrementForUnique(int[] nums) {
        int moves = 0;
        int max = 0;
        int n = nums.length;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] freqArray = new int[max + n];

        for (int i = 0; i < n; i++) {
            freqArray[nums[i]]++; 
        }

        for (int i = 0; i < freqArray.length; i++) {
            if (freqArray[i] > 1) {
                int duplicates = freqArray[i] - 1; 
                freqArray[i + 1] = freqArray[i + 1] + duplicates;
                moves = moves + duplicates; 
            }
        }

        return moves;
    }
}
