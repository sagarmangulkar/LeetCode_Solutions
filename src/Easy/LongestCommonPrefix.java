package Easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.

 If there is no common prefix, return an empty string "".

 Example 1:

 Input: ["flower","flow","flight"]
 Output: "fl"
 Example 2:

 Input: ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.
 Note:

 All given inputs are in lowercase letters a-z.
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int index = 0;
        for(index = 0; index < strs[0].length(); index++)
        {
            for(int j = 0; j < strs.length; j++)
            {
                System.out.println(" " +  strs[j].length()+ " " + index);
                if(index >= strs[j].length() || strs[j].charAt(index) != strs[0].charAt(index))
                {
                    return strs[0].substring(0,index);
                }
            }
        }
        return strs[0];
    }
}
