package Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

 Symbol       Value
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

 Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

 I can be placed before V (5) and X (10) to make 4 and 9.
 X can be placed before L (50) and C (100) to make 40 and 90.
 C can be placed before D (500) and M (1000) to make 400 and 900.
 Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

 Example 1:

 Input: "III"
 Output: 3
 Example 2:

 Input: "IV"
 Output: 4
 Example 3:

 Input: "IX"
 Output: 9
 Example 4:

 Input: "LVIII"
 Output: 58
 Explanation: C = 100, L = 50, XXX = 30 and III = 3.
 Example 5:

 Input: "MCMXCIV"
 Output: 1994
 Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

public class RomanToInteger {
    public int romanToInt(String s) {
        int res = 0, len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for(int i = len-1; i >= 0; i--) {
            char cur = s.charAt(i);
            char next = (i > 0) ? s.charAt(i-1) : 'a';
            if((i-1 >= 0) && map.get(next) < map.get(cur)) {
                res = res + (map.get(cur) - map.get(next));
                i--;
            }
            else{
                res = res + map.get(cur);
            }
        }
        return res;
    }
}



//----------------------------------------------------------
//traverse start to end

class Solution2 {
    public int romanToInt(String s) {
        int value = 0;
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int curr;
        int next;
        for (int i = 0; i < len; i++) {
            curr = map.get(s.charAt(i));
            next = (i+1 < len) ? map.get(s.charAt(i+1)) : 0;
            if (curr >= next) {
                value += curr;    
            }
            else if (curr < next) {
                value += next - curr;
                i++; 
            }
        }
        return value;
    }
}
