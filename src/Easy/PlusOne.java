package Easy;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

 The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

 You may assume the integer does not contain any leading zero, except the number 0 itself.

 Example 1:

 Input: [1,2,3]
 Output: [1,2,4]
 Explanation: The array represents the integer 123.
 Example 2:

 Input: [4,3,2,1]
 Output: [4,3,2,2]
 Explanation: The array represents the integer 4321.
 */

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1, sum = 0, length = digits.length;
        for(int i = length - 1; i >= 0; i--) {
            sum = digits[i] + carry;
            if(sum != 10) {
                digits[i] = sum;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newDigits = new int[length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}


/*
different cases to be considered:

[1,2,3] => [1,2,4]
carry = 1
input[len-1] =+ carry;

[1,9,9] => [2,0,0]
for(reserse){
if(sum == 10) carry = 1;
else carry = 0;
}

[9,9,9] => [1,0,0,0]
if(i == 0 && sum == 10){
int[] newArray = new int[len+1]
newArray[0] = 1;
return newArray;
}

[0] => [1]

[9] => [1,0]
*/