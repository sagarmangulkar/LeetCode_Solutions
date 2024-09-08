/*

Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"

Output: 0

Explanation:

The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:

Input: s = "loveleetcode"

Output: 2

Example 3:

Input: s = "aabb"

Output: -1

 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.

*/

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if(!hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), 1);
            } else {
                hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if(hm.containsKey(s.charAt(i)) && hm.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}


// Ideal solution will be to use char arr[26] instead of hm and change its values by c-`a` and comparing it with the same to return the result
