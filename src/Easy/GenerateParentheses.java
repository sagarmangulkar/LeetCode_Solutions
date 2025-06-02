/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8

*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        backTracking(answer, new StringBuilder(""), 0, 0, n);
        return answer;
    }

    public void backTracking(List<String> answer, StringBuilder sb, int leftCount, int rightCount, int n) {
        if (sb.length() == 2*n) {
            answer.add(sb.toString());
        }
        if (leftCount < n) {
            sb.append("(");
            backTracking(answer, sb, leftCount+1, rightCount, n);
            sb.deleteCharAt(sb.length()-1);
        }
        if (leftCount > rightCount) {
            sb.append(")");
            backTracking(answer, sb, leftCount, rightCount+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
