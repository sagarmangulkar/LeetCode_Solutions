/*

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

*/


class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ansList = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int[] interval : intervals) {
            if (ansList.isEmpty() || interval[0] > ansList.getLast()[1]) {
                ansList.add(interval);
            }
            else if (interval[0] <= ansList.getLast()[1]) {
                ansList.getLast()[1] = Math.max(interval[1], ansList.getLast()[1]);
            }
        }
        return ansList.toArray(new int[ansList.size()][]);
    }
}


class Solution2 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = list.getLast();
            if (lastInterval[1] >= intervals[i][0]) {
                list.getLast()[1] = Math.max(intervals[i][1], lastInterval[1]);
            }
            else {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}
