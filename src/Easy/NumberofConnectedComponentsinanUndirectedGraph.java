/*

You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

Return the number of connected components in the graph.

 

Example 1:


Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2
Example 2:


Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1
 

Constraints:

1 <= n <= 2000
1 <= edges.length <= 5000
edges[i].length == 2
0 <= ai <= bi < n
ai != bi
There are no repeated edges.

*/

class Solution {
    public int countComponents(int n, int[][] edges) {
        int ans = 0;
        Set<Integer> seen = new HashSet<>();
        Map<Integer, List<Integer>> hashMapConnectedNodes = new HashMap<>();
        //update the HashMap connected nodes
        for (int i = 0; i < edges.length; i++) {
            int first = edges[i][0];
            int second = edges[i][1];
            if (!hashMapConnectedNodes.containsKey(first)) {
                List<Integer> newList = new ArrayList<>();
                newList.add(second);
                hashMapConnectedNodes.put(first, newList);
            }
            else {
                List<Integer> tempList = hashMapConnectedNodes.get(first);
                tempList.add(second);
                hashMapConnectedNodes.put(first, tempList);
            }
            if (!hashMapConnectedNodes.containsKey(second)) {
                List<Integer> newList = new ArrayList<>();
                newList.add(first);
                hashMapConnectedNodes.put(second, newList);
            }
            else {
                List<Integer> tempList = hashMapConnectedNodes.get(second);
                tempList.add(first);
                hashMapConnectedNodes.put(second, tempList);
            }
        }

        //traverse the HashMap
        for (int i = 0; i < n; i++) {
            if (!hashMapConnectedNodes.containsKey(i)) {
                ans++;
                seen.add(i);
            }
            if (!seen.contains(i)) {
                dfs(i, hashMapConnectedNodes, seen);
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int node, Map<Integer, List<Integer>> hashMapConnectedNodes, Set<Integer> seen) {
        if (seen.contains(node)) {
            return;
        }
        seen.add(node);
        List<Integer> list = hashMapConnectedNodes.get(node);
        for (int i = 0; i < list.size(); i++) {
            dfs(list.get(i), hashMapConnectedNodes, seen);
        }
    }
}
