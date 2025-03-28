/*

Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.

 

Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"
Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"
Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"
 

Constraints:

1 <= num1.length, num2.length <= 104
num1 and num2 consist of only digits.
num1 and num2 don't have any leading zeros except for the zero itself.

*/

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i1 = num1.length()-1;
        int i2 = num2.length()-1;
        while (i1 >= 0 || i2 >= 0) {
            int n1 = (i1 >= 0) ? num1.charAt(i1)-'0' : 0;
            int n2 = (i2 >= 0) ? num2.charAt(i2)-'0' : 0;
            int sum = (n1 + n2 + carry)%10;
            carry = (n1 + n2 + carry)/10;
            sb.append(sum);
            i1--;
            i2--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        sb.reverse();
        return sb.toString();
    }
}
