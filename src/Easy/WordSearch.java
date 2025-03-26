/*

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board?

*/

class Solution {
    char[][] board;
    int ROW;
    int COL;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.ROW = board.length;
        this.COL = board[0].length;
        for (int row = 0; row < this.ROW; ++row) {
            for (int col = 0; col < this.COL; ++col) {
                if (backTrack(word, row, col, 0))
                    return true;
            }   
        }
        return false;
    }

    public boolean backTrack(String word, int row, int col, int wordIndex) {
        if (wordIndex >= word.length()) {
            return true;
        }
        if (row < 0 
        || row >= this.ROW 
        || col < 0 
        || col >= this.COL 
        || this.board[row][col] != word.charAt(wordIndex) ) {
            return false;
        }

        this.board[row][col] = '#';
        if(backTrack(word, row, col+1, wordIndex+1) || 
        backTrack(word, row+1, col, wordIndex+1) || 
        backTrack(word, row, col-1, wordIndex+1) || 
        backTrack(word, row-1, col, wordIndex+1)) {
            return true;
        }

        this.board[row][col] = word.charAt(wordIndex);
        return false;
    }
}
