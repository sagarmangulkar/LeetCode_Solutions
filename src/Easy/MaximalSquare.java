/*

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

 

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4
Example 2:


Input: matrix = [["0","1"],["1","0"]]
Output: 1
Example 3:

Input: matrix = [["0"]]
Output: 0
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.

*/

//Brutforce approach
class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int maxSquareLen = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int squareLen = grow(matrix, i, j, row, col);
                maxSquareLen = Math.max(maxSquareLen, squareLen);
            }
        }
        return maxSquareLen * maxSquareLen;
    }

    public int grow(char[][] matrix, int i, int j, int row, int col) {
        boolean isOne = true;
        int squareLen = 1;
        while (i + squareLen < row && j + squareLen < col && isOne) {
            for (int k = j; (k <= squareLen + j) && isOne; k++) {
                if (matrix[i+squareLen][k] == '0') {
                    isOne = false;
                    break;
                }
            }
            for (int k = i; k <= (squareLen + i) && isOne; k++) {
                if (matrix[k][j+squareLen] == '0') {
                    isOne = false;
                    break;
                }
            }
            if (isOne) {
                squareLen++;
            }
        }
        return squareLen;
    }
}




//DP
class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = row > 0 ? matrix[0].length : 0;;
        int maxSquareLen = 0;
        int[][] dp = new int[row+1][col+1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i-1][j-1] == '0') {
                    continue;
                }
                dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                maxSquareLen = Math.max(maxSquareLen, dp[i][j]);
            }
        }
        return maxSquareLen * maxSquareLen;
    }
}
