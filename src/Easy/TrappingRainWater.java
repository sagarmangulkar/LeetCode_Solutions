/*

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105

*/


class Solution {
    public int trap(int[] height) {
        int water = 0;
        int left = 0;
        int leftMax = 0;
        int right = height.length-1;
        int rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                left++;
            }
            else if (height[left] >= height[right]) {
                rightMax = Math.max(height[right], rightMax);
                right--;
            }
            water = water + Math.min(Math.max(height[left], leftMax), Math.max(height[right], rightMax)) - Math.min(height[left], height[right]);
        }
        return water;
    }
}
