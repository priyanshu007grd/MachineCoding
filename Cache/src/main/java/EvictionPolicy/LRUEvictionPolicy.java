package EvictionPolicy;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key>{

    DoublyLinkedListNode<Key> head;
    DoublyLinkedListNode<Key> tail;
    Map<Key,DoublyLinkedListNode<Key>> keyM;

    public LRUEvictionPolicy() {
        head = new DoublyLinkedListNode<Key>(null);
        tail = new DoublyLinkedListNode<Key>(null);
        head.next = tail;
        tail.prev = head;

        keyM = new HashMap<Key, DoublyLinkedListNode<Key>>();
    }

    @Override
    public void keyAccessed(Key key) {
        if(keyM.containsKey(key)) {

            DoublyLinkedListNode node = keyM.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;

            DoublyLinkedListNode tailPrev = tail.prev;
            tailPrev.next = node;
            node.next = tail;
            tail.prev = node;
            node.prev = tailPrev;
        } else {
            DoublyLinkedListNode<Key> node = new DoublyLinkedListNode<Key>(key);
            keyM.put(key,node);
            DoublyLinkedListNode tailPrev = tail.prev;
            tailPrev.next = node;
            node.next = tail;
            tail.prev = node;
            node.prev = tailPrev;
        }
        DoublyLinkedListNode<Key> t = head.next;
        while(t!=tail) {
            System.out.println(t.key);
            t=t.next;
        }
    }

    @Override
    public Key evictKey() throws Exception {

        if(head.next == tail) throw new Exception("LRU is empty");
        DoublyLinkedListNode<Key> node = head.next;
        node.prev.next = node.next;
        node.next.prev = head;
        return  node.key;
    }
}
