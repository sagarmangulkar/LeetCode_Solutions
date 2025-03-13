/*

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

*/



import static java.lang.Math.min;
import static java.lang.System.out;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        // PriorityQueue with increasing order of occurences (freq.value), so poll will return lowest occurences num
        Queue<Integer> minHeap = new PriorityQueue<>(
            (n1, n2) -> freq.get(n1) - freq.get(n2)
        );
        // insert num and their occurences in HashMap
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // insert keys in PriorityQueue
        for (Integer key : freq.keySet()) {
            minHeap.add(key);
        }

        // remove nums until size of PriorityQueue becomes k
        while (minHeap.size() > k) {
            minHeap.poll();
        }

        // convert PriorityQueue to int array
        int[] output = new int[minHeap.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = minHeap.poll();
        }
        return output;
    }
}
