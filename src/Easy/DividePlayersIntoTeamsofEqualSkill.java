/*

You are given a positive integer array skill of even length n where skill[i] denotes the skill of the ith player. Divide the players into n / 2 teams of size 2 such that the total skill of each team is equal.

The chemistry of a team is equal to the product of the skills of the players on that team.

Return the sum of the chemistry of all the teams, or return -1 if there is no way to divide the players into teams such that the total skill of each team is equal.

 

Example 1:

Input: skill = [3,2,5,1,3,4]
Output: 22
Explanation: 
Divide the players into the following teams: (1, 5), (2, 4), (3, 3), where each team has a total skill of 6.
The sum of the chemistry of all the teams is: 1 * 5 + 2 * 4 + 3 * 3 = 5 + 8 + 9 = 22.
Example 2:

Input: skill = [3,4]
Output: 12
Explanation: 
The two players form a team with a total skill of 7.
The chemistry of the team is 3 * 4 = 12.
Example 3:

Input: skill = [1,1,2,3]
Output: -1
Explanation: 
There is no way to divide the players into teams such that the total skill of each team is equal.
 

Constraints:

2 <= skill.length <= 105
skill.length is even.
1 <= skill[i] <= 1000

*/

//using Sorting
class Solution {
    public long dividePlayers(int[] skill) {
        long chemistry = 0;
        int n = skill.length;
        Arrays.sort(skill);
        int targetSkillsPerTeam = skill[0] + skill[n-1];
        for(int i = 0, j = n-1; i < n/2; i++, j--) {
            if (skill[i] + skill[j] == targetSkillsPerTeam) {
                chemistry = chemistry + (skill[i] * skill[j]);
            }
            else {
                return -1;
            }
        }
        return chemistry;
    }
}

//using Freq HM like 2Sum
class Solution {
    public long dividePlayers(int[] skill) {
        long chemistry = 0;
        int n = skill.length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            min = Math.min(min, skill[i]);
            max = Math.max(max, skill[i]);
        }
        int targetSkillsPerTeam = min + max;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < n; i++) {
            freq.put(skill[i], freq.getOrDefault(skill[i], 0) + 1);
        }
        for(int i = 0; i < n; i++) {
            int teamMateSkill = targetSkillsPerTeam - skill[i];
            if (freq.containsKey(teamMateSkill) && freq.get(teamMateSkill) > 0) {
                freq.put(teamMateSkill, freq.get(teamMateSkill) - 1);
                chemistry = chemistry + (skill[i] * teamMateSkill);
            }
            else {
                return -1;
            }
        }
        return chemistry/2;
    }
}
