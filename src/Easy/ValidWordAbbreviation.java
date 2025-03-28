/*

A string can be abbreviated by replacing any number of non-adjacent, non-empty substrings with their lengths. The lengths should not have leading zeros.

For example, a string such as "substitution" could be abbreviated as (but not limited to):

"s10n" ("s ubstitutio n")
"sub4u4" ("sub stit u tion")
"12" ("substitution")
"su3i1u2on" ("su bst i t u ti on")
"substitution" (no substrings replaced)
The following are not valid abbreviations:

"s55n" ("s ubsti tutio n", the replaced substrings are adjacent)
"s010n" (has leading zeros)
"s0ubstitution" (replaces an empty substring)
Given a string word and an abbreviation abbr, return whether the string matches the given abbreviation.

A substring is a contiguous non-empty sequence of characters within a string.

 

Example 1:

Input: word = "internationalization", abbr = "i12iz4n"
Output: true
Explanation: The word "internationalization" can be abbreviated as "i12iz4n" ("i nternational iz atio n").
Example 2:

Input: word = "apple", abbr = "a2e"
Output: false
Explanation: The word "apple" cannot be abbreviated as "a2e".
 

Constraints:

1 <= word.length <= 20
word consists of only lowercase English letters.
1 <= abbr.length <= 10
abbr consists of lowercase English letters and digits.
All the integers in abbr will fit in a 32-bit integer.

*/


class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word.length() < abbr.length()) {
            return false;
        }
        int j = 0;
        int i = 0;
        while (i < word.length() && j < abbr.length()) {
            //move on if both Characters are same
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }
            // check for first 0 digit
            if (Character.isDigit(abbr.charAt(j))) {
                int firstDigit = Integer.parseInt(abbr.substring(j, j+1));
                if (firstDigit == 0) {
                    return false;
                }
            }
            //get full number and bring i there
            int start = j;
            while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                j++;
            }
            int end = j;
            if (start >= end) {
                return false;
            }
            int num = Integer.valueOf(abbr.substring(start, end));
            i = i + num;
        }
        //check if there are aligned at the end
        return i == word.length() && j == abbr.length();
    }
}
