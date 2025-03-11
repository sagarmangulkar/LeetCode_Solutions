/*

Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.

If there is no common time slot that satisfies the requirements, return an empty array.

The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.

It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.

 

Example 1:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
Output: [60,68]
Example 2:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
Output: []
 

Constraints:

1 <= slots1.length, slots2.length <= 104
slots1[i].length, slots2[i].length == 2
slots1[i][0] < slots1[i][1]
slots2[i][0] < slots2[i][1]
0 <= slots1[i][j], slots2[i][j] <= 109
1 <= duration <= 106

*/


class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> output = new ArrayList<>();
        int len1 = slots1.length;
        int len2 = slots2.length;
        int i1 = 0;
        int i2 = 0;
        Arrays.sort(slots1, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(slots2, (a, b) -> Integer.compare(a[0], b[0]));
        while (i1 < len1 && i2 < len2) {
            int[] slot1 = slots1[i1];
            int[] slot2 = slots2[i2];
            if (slot1[1] - slot1[0] < duration || slot1[1] - slot2[0] < duration) {
                i1++;
            }
            if (slot2[1] - slot2[0] < duration || slot2[1] - slot1[0] < duration) {
                i2++;
            }
            if (Math.min(slot1[1], slot2[1]) - Math.max(slot1[0], slot2[0]) >= duration) {
                int start = Math.min(Math.min(slot1[1], slot2[1]), Math.max(slot1[0], slot2[0]));
                output.add(start);
                output.add(start + duration);
                return output;
            }
        }
        return output;
    }
}
