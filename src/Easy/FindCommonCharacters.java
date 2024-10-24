/*

Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

 

Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.

*/

class Solution {
    public List<String> commonChars(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> common = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (!map.containsKey(ch)) {
                    map.put(ch, 1);
                }
                else {
                    map.put(ch, map.get(ch) + 1);
                }
            }
            if (i == 0) {
                common.putAll(map);
            }
            else {
                for (char ch : common.keySet()) {
                    if (!map.containsKey(ch)) {
                        common.put(ch, 0);
                    }
                    else if (map.get(ch) < common.get(ch)) {
                        common.put(ch, map.get(ch));
                    }
                }
            }
            map.clear();
        }

        List<String> list = new ArrayList<>();
        for (char ch : common.keySet()) {
            while (common.get(ch) != 0) {
                list.add(String.valueOf(ch));
                common.put(ch, common.get(ch)-1);
            }
        }
        return list;
    }
}
