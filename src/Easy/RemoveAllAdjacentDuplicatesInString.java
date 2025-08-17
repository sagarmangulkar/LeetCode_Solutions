/*


You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

 

Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay"
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.


*/


class Solution {
    public String removeDuplicates(String s) {
      char [] ch = s.toCharArray();
      int index = -1;

      for (char c : ch) {
        if ( index > -1 && ch[index] == c ) {
            index --;
        }
        else {
            index ++;
            ch[index]=c;
        }
      }  

     return new String(ch, 0, index + 1);
    }
}

//using stack
class Solution2 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.empty() && stack.peek() == ch) {
                stack.pop();
            }
            else {
                stack.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Character> iterator = stack.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        return sb.toString();
    }
}

//using StringBuilder
class Solution3 {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length()) {
            if (i < sb.length() - 1 && sb.charAt(i) == sb.charAt(i+1)) {
                sb.deleteCharAt(i+1);
                sb.deleteCharAt(i);
                if (i > 0) {
                    i--;
                }
            }
            else {
                i++;
            }
        }
        return sb.toString();
    }
}
