/*

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.

*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = board.length;
        int[] rowArray = new int[N*N];
        int[] colArray = new int[N*N];
        int[] boxArray = new int[N*N];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                int num = board[row][col] - '1';
                int rowPos = (row * 9) + num;
                if (rowArray[rowPos] == 1) {
                    return false;
                }
                rowArray[rowPos] = 1;

                int colPos = (col * 9) + num;
                if (colArray[colPos] == 1) {
                    return false;
                }
                colArray[colPos] = 1;

                int boxPos = (row/3) * 3 + (col/3);
                boxPos = (boxPos * 9) + num;
                if (boxArray[boxPos] == 1) {
                    return false;
                }
                boxArray[boxPos] = 1;
            }
        }
        return true;
    }
}
