/*

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

 

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
 

Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.

*/

class DLL {
    int key;
    int value;
    DLL next;
    DLL prev;
    
    public DLL(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, DLL> map;
    DLL head;
    DLL tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, DLL>();
        head = new DLL(0, 0);
        tail = new DLL(0, 0);
        this.head.next = this.tail;
        this.head.prev = null;
        this.tail.prev = this.head;
        this.tail.next = null;
    }
    
    public void add(DLL node) {
        DLL prev = this.tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }
    
    public void remove(DLL node) {
        DLL prev = node.prev;
        DLL next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DLL node = map.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLL node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            remove(node);
        }
        else {
            if (this.capacity == map.size()) {
                DLL leastUsedNode = this.head.next;
                remove(leastUsedNode);
                map.remove(leastUsedNode.key);
            }
            node = new DLL(key, value);
        }
        map.put(key, node);
        add(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

