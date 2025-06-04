/*

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30

*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int row = 1; row <= numRows; row++) {
            List<Integer> rowList = new ArrayList<>();
            for (int col = 0; col < row; col++) {
                if (col == 0 || col == row-1) {
                    rowList.add(1);
                    continue;
                }
                int first = ans.get(row-2).get(col-1);
                int second = ans.get(row-2).get(col);
                rowList.add(first + second);
            }
            ans.add(rowList);
        }
        return ans;
    }
}
