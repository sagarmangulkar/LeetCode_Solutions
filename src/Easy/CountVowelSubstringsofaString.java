/*

A substring is a contiguous (non-empty) sequence of characters within a string.

A vowel substring is a substring that only consists of vowels ('a', 'e', 'i', 'o', and 'u') and has all five vowels present in it.

Given a string word, return the number of vowel substrings in word.

 

Example 1:

Input: word = "aeiouu"
Output: 2
Explanation: The vowel substrings of word are as follows (underlined):
- "aeiouu"
- "aeiouu"
Example 2:

Input: word = "unicornarihan"
Output: 0
Explanation: Not all 5 vowels are present, so there are no vowel substrings.
Example 3:

Input: word = "cuaieuouac"
Output: 7
Explanation: The vowel substrings of word are as follows (underlined):
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
- "cuaieuouac"
 

Constraints:

1 <= word.length <= 100
word consists of lowercase English letters only.


*/

class Solution {
    public int countVowelSubstrings(String word) {
        Set<Character> vowelsSet = new HashSet<>();
        int vowelsSubStringCount = 0;
        for (int i = 0; i < word.length() - 4; i++) {
            for (int j = i; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (isVowel(ch)) {
                    vowelsSet.add(ch);
                    if (vowelsSet.size() == 5) {
                        vowelsSubStringCount++;
                    }
                }
                else {
                    break;
                }
            }
            vowelsSet.clear();
        }
        return vowelsSubStringCount;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
