package lld.lrucache;

public class DoublyLinkedList<K,V> {
    Node<K,V> head; // dummy node
    Node<K,V> tail; // dummy node

    DoublyLinkedList(){
        head = new Node<>(null,null);
        tail = new Node<>(null,null);;
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node<K,V> node){
        // insert the node after the head
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void remove(Node<K,V> node){
        // Remove this node from the position as Hashmap is pointing to this node
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToFront(Node<K,V> node){
        this.remove(node);
        this.addFirst(node);
    }

    public Node<K,V> removeLast(){
        if(tail.prev == head){
            return null;
        }
        Node<K,V> lastNode = tail.prev;
        this.remove(lastNode);
        return lastNode;
    }
}
