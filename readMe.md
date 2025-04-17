## 🧠 Intuition Behind the Design

### 📘 1. Why Use a `HashMap` for Storage?

- The cache needs to support **constant-time lookup, insertion, and deletion** of key-value pairs.
- `HashMap<K, V>` is a perfect data structure for this use case because:
    - `put(K, V)` → O(1)
    - `get(K)` → O(1)
    - `remove(K)` → O(1)
- This ensures your cache operations are **fast and scalable**, even when your cache size grows.
- It also allows the eviction policy to remove a key from storage without knowing anything about how the values are stored.

---

### 🔁 2. Why Use a Doubly Linked List for Eviction Order?

- The eviction strategy implemented here is **Least Recently Used (LRU)**.
- In LRU, the **least recently accessed item** should be evicted when the cache is full.
- A **doubly linked list** helps maintain access order:
    - **Head** of the list → least recently used item.
    - **Tail** of the list → most recently used item.
- Each time a key is accessed (via `get` or `put`), its node is **moved to the tail**, showing it was recently used.
- Doubly linked list allows:
    - O(1) insertion at the tail.
    - O(1) removal from any position (because each node has a reference to both its previous and next node).
- This makes it ideal for LRU eviction, where frequent reordering of access is necessary.

---

### 🤩 3. Why Maintain a Map of `Key → Node` in Eviction Policy?

- To achieve **O(1)** time complexity for updating the position of an item in the doubly linked list, we need **direct access to the node** representing a key.
- So, we maintain a `Map<K, Node<K>>`:
    - The map lets you jump straight to the node in the list for a given key.
    - This avoids the need to search the linked list linearly, which would be O(n).
- When a key is accessed:
    - Lookup the node using the map.
    - Remove it from its current position.
    - Move it to the tail of the list.
- When evicting:
    - Remove the head of the list.
    - Also remove the key from the map to avoid memory leaks.

---

### 🔄 Final Picture

| Data Structure     | Purpose                                 | Time Complexity |
|--------------------|------------------------------------------|-----------------|
| `Map<K, V>`        | Stores key-value data                    | O(1)            |
| `DoublyLinkedList` | Maintains access order for LRU eviction  | O(1) ops        |
| `Map<K, Node<K>>`  | Maps keys to their position in the list  | O(1) access     |

