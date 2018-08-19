package Easy;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

 Example 1:

 Input: 121
 Output: true
 Example 2:

 Input: -121
 Output: false
 Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 Example 3:

 Input: 10
 Output: false
 Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String xString = "" + x;
        int length = xString.length();
        int i = 0, j = length - 1;
        while((xString.charAt(i) == xString.charAt(j)) && (i < j)){
            i++;
            j--;
        }
        return i >= j;
    }
}
