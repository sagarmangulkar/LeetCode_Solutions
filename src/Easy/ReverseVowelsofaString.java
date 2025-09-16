/*

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

 

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"

 

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.

*/

class Solution {
    public String reverseVowels(String s) {
        Set<Character> vovelSet = new HashSet<>();
        vovelSet.add('a');
        vovelSet.add('e');
        vovelSet.add('i');
        vovelSet.add('o');
        vovelSet.add('u');
        vovelSet.add('A');
        vovelSet.add('E');
        vovelSet.add('I');
        vovelSet.add('O');
        vovelSet.add('U');
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (vovelSet.contains(ch)) {
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (vovelSet.contains(sb.charAt(i))) {
                sb.replace(i, i+1, stack.pop().toString());
            }
        }
        return sb.toString();
    }
}
