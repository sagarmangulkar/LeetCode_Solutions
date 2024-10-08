/*

Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

 

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"

*/


class Solution {
    public String largestNumber(int[] nums) {
        String[] numsString = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsString[i] = Integer.toString(nums[i]);
        }

        Comparator<String> comp = new Comparator<>(){
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
            }
        };
        Arrays.sort(numsString, comp);

        if (numsString[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String num : numsString) {
            sb.append(num);
        }
        return sb.toString();
    }
}
