package Easy;

/**
 * Given an integer, write a function to determine if it is a power of three.

 Example 1:

 Input: 27
 Output: true
 Example 2:

 Input: 0
 Output: false
 Example 3:

 Input: 9
 Output: true
 Example 4:

 Input: 45
 Output: false
 Follow up:
 Could you do it without using any loop / recursion?
 */

//my solution is using loop, still open for solving it without loop/recursion.
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        double d = n;
        while(d%3 == 0 && d > 1) {
            d = d/3;
        }
        return d == 1;
    }
}
