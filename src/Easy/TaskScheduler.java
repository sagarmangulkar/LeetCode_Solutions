/*

You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.

Return the minimum number of CPU intervals required to complete all tasks.

 

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2

Output: 8

Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.

Example 2:

Input: tasks = ["A","C","A","B","D","B"], n = 1

Output: 6

Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.

With a cooling interval of 1, you can repeat a task after just one other task.

Example 3:

Input: tasks = ["A","A","A", "B","B","B"], n = 3

Output: 10

Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.

There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.

 

Constraints:

1 <= tasks.length <= 104
tasks[i] is an uppercase English letter.
0 <= n <= 100

*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int processedIntervals = 0;
        int[] freqArray = new int[26];
        //freq like HashMap
        for (char ch : tasks) {
            freqArray[ch - 'A'] = freqArray[ch - 'A'] + 1;
        }

        //MaxHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int freqInt : freqArray) {
            if (freqInt > 0) {
                pq.offer(freqInt);
            }
        }

        //procees pq elements and move to store list
        while (!pq.isEmpty()) {
            int cycle = n + 1;
            int cycleTime = 0;
            //empty store list
            List<Integer> store = new ArrayList<>();
            while (cycle > 0 && !pq.isEmpty()) {
                int currTask = pq.poll();
                currTask--;
                if (currTask > 0) {
                    store.add(currTask);
                }
                cycleTime++;
                cycle--;
            }
            //add store's elements into pq
            store.forEach(pq::offer);
            processedIntervals += (pq.isEmpty()) ? cycleTime : n + 1;
        }
        return processedIntervals;
    }
}

/*

ACABDB, 1
ACABDB - 6

AAABBB, 3
AB11AB11AB - 10
A - 2
B - 3
*/
