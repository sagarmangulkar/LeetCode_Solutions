/*

Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n-1;
        int up = 0;
        int down = m-1;
        List<Integer> ans = new ArrayList<>();
        while (ans.size() < m*n) {
            //left -> right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[up][i]);
            }
            //up -> down
            for (int i = up+1; i <= down; i++) {
                ans.add(matrix[i][right]);
            }
            //right -> left
            if (up != down) {
                for (int i = right-1; i >= left; i--) {
                    ans.add(matrix[down][i]);
                }
            }
            //down -> up
            if (left != right) {
                for (int i = down-1; i > up; i--) {
                    ans.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            up++;
            down--;

        }
        return ans;
    }
}
