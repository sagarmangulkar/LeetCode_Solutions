/*

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

*/


// DP Top Down - with Memoizatino
class Solution {
    int[] coins;
    Map<Integer, Integer> memo = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        return dp(amount);
    }
    
    public int dp(int remainingAmount) {
        if (remainingAmount == 0) {
            return 0;
        }
        if (remainingAmount < 0) {
            return -1;
        }
        if (memo.containsKey(remainingAmount)) {
            return memo.get(remainingAmount);
        }
        int minChange = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            int res = dp(remainingAmount - coins[i]);
            if (res >= 0 && res < minChange) {
                minChange = res + 1;
            }
        }
        if (minChange == Integer.MAX_VALUE) {
            memo.put(remainingAmount, -1);
        }
        else {
            memo.put(remainingAmount, minChange);
        }
        return memo.get(remainingAmount);
    }
}
