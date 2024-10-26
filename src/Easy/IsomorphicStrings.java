/*

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true

 

Constraints:

1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.

*/



class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        List<Integer> listS = new ArrayList<>(mapS.values());
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!mapS.containsKey(ch)) {
                mapS.put(ch, i);
                listS.add(i);
            }
            else {
                listS.add(mapS.get(ch));
            }
        }
        Map<Character, Integer> mapT = new HashMap<>();
        List<Integer> listT = new ArrayList<>(mapT.values());
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!mapT.containsKey(ch)) {
                mapT.put(ch, i);
                listT.add(i);
            }
            else {
                listT.add(mapT.get(ch));
            }
        }

        //Collections.sort(listS);
        //Collections.sort(listT);

        return listS.equals(listT);
    }
}
