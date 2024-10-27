/*

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104

*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int[] array = new int[max - min + 1];
        for(int i = 0; i < nums.length; i++) {
            array[nums[i] - min]++;
        }
        int count = k;
        for(int i = array.length-1; i >= 0; i--) {
            count = count - array[i];
            if (count <= 0) {
                return i + min;
            }
        }
        return -1;
    }
}
