/*

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.

*/

class TrieNode {
    TrieNode[] links;
    boolean isEnd;
    public TrieNode() {
        this.links = new TrieNode[26];
        this.isEnd = false;
    }
    
    boolean contains(char ch) {
        return links[ch - 'a'] != null;
    }
    
    TrieNode getNode(char ch) {
        return links[ch - 'a'];
    }

    void putNode(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    void setEnd() {
        this.isEnd = true;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.contains(ch)) {
                node.putNode(ch, new TrieNode());
            }
            node = node.getNode(ch);
        }
        node.setEnd();
    }

    public TrieNode searchPrefix(String word) {
        if (root == null) {
            return null;
        }
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.contains(ch)) {
                return null;
            }
            node = node.getNode(ch);
        }
        return node;
    }
    
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
