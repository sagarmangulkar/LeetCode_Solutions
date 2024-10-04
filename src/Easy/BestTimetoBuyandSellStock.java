/*

You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104

*/


class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int maxDiff = 0;
        for (int b = 0; b < len-1; b++) {
            int s = b+1;
            while (s < len) {
                int currDiff = prices[s] - prices[b];
                if (currDiff > 0) {
                    maxDiff = (currDiff > maxDiff) ? currDiff : maxDiff;
                    s++;
                }
                else if (currDiff <= 0) {
                    b = s;
                    s = b+1;
                }
            }
        }
        return maxDiff;
    }
}


//--------------------------------------------------------

class Solution2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int maxDiff = Integer.MIN_VALUE;
        int minStock = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            minStock = Math.min(prices[i], minStock);
            maxDiff = Math.max(prices[i] - minStock, maxDiff);
        }
        return maxDiff;
    }
}
