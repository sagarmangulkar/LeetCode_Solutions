/*

Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

 

Example 1:


Input: n = 3
Output: 5
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 19

*/


class Solution {
    public int numTrees(int n) {
        if (n == 0) 
            return 0;
        if (n == 1) 
            return 1;
        return count(1, n);
    }

    public int count(int start, int end) {
        int sum = 0;
        if (start >= end) {
                return 1;
        }
        for (int i = start; i <= end; i++) {
            int left = count(start, i-1);
            int right = count(i+1, end);
            sum = sum + (left * right);
        }
        return sum;
    }
}
