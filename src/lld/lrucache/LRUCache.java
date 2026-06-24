package lld.lrucache;

import java.util.HashMap;
import java.util.Map;

/*
Key Design Principles:

Single Responsibility: The LRU Cache coordinates operations but delegates ordering to DoublyLinkedList and lookup to HashMap. Each component does one thing well.
Encapsulation: The internal data structures are private. Callers only see get and put. They don't know about nodes, linked lists, or eviction mechanics.
Thread Safety: Both get and put should be synchronized to prevent race conditions in multi-threaded environments.

*/
public class LRUCache<K,V> {
    private final int capacity;
    private final Map<K, Node<K,V>> map;
    private final DoublyLinkedList<K,V> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.list = new DoublyLinkedList<>();
    }

    public synchronized V get(K key) {
        if(!this.map.containsKey(key)){
            return null;
        }
        Node<K,V> node = this.map.get(key);
        this.list.moveToFront(node);
        return node.value;
    }

    public synchronized void put(K key, V value){
        if(map.containsKey(key)){
            Node<K,V> node = map.get(key);
            node.value = value;
            this.list.remove(node);
            this.list.moveToFront(node);
        }else {
            if(capacity == map.size()){
                Node<K,V> node = this.list.removeLast();
                this.map.remove(node.key);
            }
            Node<K, V> node = new Node(key, value);
            map.put(key, node);
            this.list.addFirst(node);
        }
    }

}
