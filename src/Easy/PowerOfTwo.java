package Easy;

/**
 * Given an integer, write a function to determine if it is a power of two.

 Example 1:

 Input: 1
 Output: true
 Explanation: 20 = 1
 Example 2:

 Input: 16
 Output: true
 Explanation: 24 = 16
 Example 3:

 Input: 218
 Output: false
 */

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return ((n & (n-1)) == 0 && (n > 0));
    }
}

/*
Approach explanation
1 : 01 - 1 = 0
2 : 10
4 : 100
8 : 1000
16 : 10000 - 1 = 01111
15 : 1111 - 1 = 0111
0 AND 1 = 0 //00000     0100
*/