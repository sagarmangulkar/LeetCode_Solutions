/*

You are given a list of songs where the ith song has a duration of time[i] seconds.

Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

 

Example 1:

Input: time = [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60
Example 2:

Input: time = [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 

Constraints:

1 <= time.length <= 6 * 104
1 <= time[i] <= 500

*/

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int pairCount = 0;
        for (int t : time) {
            if (t % 60 == 0) {
                pairCount = pairCount + remainders[0];
            }
            else {
                pairCount = pairCount + remainders[60 - (t % 60)]; //we are checking for its subtracted remainder from 60 same like 2 SUM
            }
            remainders[t % 60]++;
        }
        return pairCount;
    }
}
