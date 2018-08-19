package Easy;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        int[] result = new int[2];
        for(int i = 0; i < length; i++) {
            map.put(target - nums[i], i);
        }
        for(int i = 0; i < length; i++) {
            if(map.containsKey(nums[i]) && i != map.get(nums[i])) {
                result[0] = i;
                result[1] = map.get(nums[i]);
                break;
            }
        }
        return result;
    }
}
