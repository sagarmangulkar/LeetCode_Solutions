/*

Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.

Return any possible rearrangement of s or return "" if not possible.

 

Example 1:

Input: s = "aab"
Output: "aba"
Example 2:

Input: s = "aaab"
Output: ""
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.

*/


class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        char[] output = new char[s.length()];
        int maxFreq = 0;
        char maxFreqChar = '-';

        //add it in hm and find maxFreq and maxFreqChar
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            if (freq.get(ch) >= maxFreq) {
                maxFreq = freq.get(ch);
                maxFreqChar = ch;
            }
        }

        //if impossible to rearrange
        if (maxFreq > (s.length() + 1)/2) {
            return "";
        }

        //start rearranging with maxFreq character
        int i = 0;
        for(int k=0; k < maxFreq; k++){
            output[i]= maxFreqChar;
            i+=2;
        }
        freq.remove(maxFreqChar);

        //rearrange alternatively
        for (Character ch : freq.keySet()) {
            int charCount = freq.get(ch);
            while (charCount > 0) {
                if (i >= output.length) {
                    i = 1;
                }
                output[i] = ch;
                i = i + 2;
                charCount--;
            }
        }
        return String.valueOf(output);
    }
}
