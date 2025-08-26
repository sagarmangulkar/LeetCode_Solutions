/*

An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).

Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.

 

Example 1:


Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
Output: true
Explanation: In this case, n = 3, and every row and column contains the numbers 1, 2, and 3.
Hence, we return true.
Example 2:


Input: matrix = [[1,1,1],[1,2,3],[1,2,3]]
Output: false
Explanation: In this case, n = 3, but the first row and the first column do not contain the numbers 2 or 3.
Hence, we return false.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
1 <= matrix[i][j] <= n

*/

class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        Set<Integer> setCol = new HashSet<>();
        Set<Integer> setRow = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int numCol = matrix[i][j];
                int numRow = matrix[j][i];
                //another same check
                // if (set1.contains(numCol) || set2.contains(numRow)) {
                //     return false;
                // }
                setCol.add(numCol);
                setRow.add(numRow);
            }
            if (setCol.size() != n || setRow.size() != n) {
                return false;
            }
            setCol.clear();
            setRow.clear();
        }
        return true;
    }
}
