/*

Given a string s, return the longest 
palindromic
 
substring
 in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.

*/


class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int ansLeft = 0;
        int ansRight = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i+1 < len && s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                ansLeft = i;
                ansRight = i+1;
            }
        }
        for (int diff = 2; diff < len; diff++) {
            for (int i = 0; i < len - diff; i++) {
                int j = i + diff;
                if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    ansLeft = i;
                    ansRight = j;
                }
            }
        }
        return s.substring(ansLeft, ansRight+1);
    }
}
