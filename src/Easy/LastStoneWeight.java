/*

You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0.

 

Example 1:

Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
Example 2:

Input: stones = [1]
Output: 1
 

Constraints:

1 <= stones.length <= 30
1 <= stones[i] <= 1000

*/

class Solution {
    public int lastStoneWeight(int[] stones) {
        for (int i = stones.length-1; i > 0 ; i--) {
            Arrays.sort(stones);
            stones[i-1] = stones[i] - stones[i-1];
            stones[i] = Integer.MAX_VALUE;
            if (i == 1) {
                return stones[i-1];
            }
            if (stones[i-1] == 0) {
                stones[i-1] = Integer.MAX_VALUE;
                i--;
            }
        }
        return stones[0];
    }
}

//using PriorityQueue
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> b-a
        );
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }
        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if (x < y) {
                pq.add(y-x);
            }
        }
        return (pq.isEmpty()) ? 0 : pq.poll();
    }
}
