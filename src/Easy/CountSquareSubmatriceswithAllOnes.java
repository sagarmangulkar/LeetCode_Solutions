/*

Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 

Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1

*/

class Solution {
    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                sum = sum + helperDP(dp, matrix, i, j);
            }
        }
        return sum;
    }

    public int helperDP(int[][] dp, int[][] matrix, int i, int j) {
        if (i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        if (matrix[i][j] == 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int right = helperDP(dp, matrix, i, j+1);
        int diagonal = helperDP(dp, matrix, i+1, j+1);
        int bottom = helperDP(dp, matrix, i+1, j);
        dp[i][j] = 1 + Math.min(right, Math.min(diagonal, bottom));
        return dp[i][j];
    }
}
