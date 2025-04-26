/*

Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.

*/

class Solution {
    int[][] memo;
    String text1;
    String text2;
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        memo = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                this.memo[i][j] = -1;
            }
        }
        return dp(0, 0);
    }

    public int dp(int i, int j) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }
        if (memo[i][j] == -1) {
            if (text1.charAt(i) == text2.charAt(j)) {
                memo[i][j] = dp(i+1, j+1) + 1;
            }
            memo[i][j] = Math.max(memo[i][j], Math.max(dp(i+1, j), dp(i, j+1)));
        }
        return memo[i][j];
    }
}
