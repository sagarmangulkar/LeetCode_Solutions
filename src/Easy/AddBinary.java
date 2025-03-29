/*

Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.

*/

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aLen = a.length();
        int bLen = b.length();
        int carry = 0;
        int aIndex = aLen - 1;
        int bIndex = bLen - 1;
        while (aIndex >= 0 || bIndex >= 0) {
            char aChar = (aIndex >= 0) ? a.charAt(aIndex) : '0';
            char bChar = (bIndex >= 0) ? b.charAt(bIndex) : '0';
            int sum = aChar - '0' + bChar - '0' + carry;
            carry = 0;
            if (sum >= 2) {
                carry = 1;
                sum = sum - 2;
            }
            sb.append(sum);
            aIndex--;
            bIndex--;
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
