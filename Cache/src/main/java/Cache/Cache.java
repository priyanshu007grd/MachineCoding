package Cache;

import EvictionPolicy.*;
import Storage.*;
import Exception.*;

public class Cache<Key,Value> {

    Storage<Key,Value> storage;
    EvictionPolicy<Key> evictionPolicy;

    public Cache(Integer capacity) {
        this.storage = new HashMapStorage<Key, Value>(capacity);
        this.evictionPolicy = new LRUEvictionPolicyLinkedHashMap<Key>();
    }

    public Value get(Key key) {
        try {
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        } catch (KeyNotFound notFoundException) {
            System.out.println("Tried to access non-existing key.");
            return null;
        }
    }


    public void put(Key key, Value value) {
        try {
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException exception) {
            System.out.println("Got storage full. Will try to evict.");
            Key keyToRemove = null;
            try {
                keyToRemove = evictionPolicy.evictKey();
            } catch (Exception e) {
                throw new RuntimeException("Unexpected State. Storage full and no key to evict.");
            }

            this.storage.remove(keyToRemove);
            System.out.println("Creating space by evicting item..." + keyToRemove);
            put(key, value);
        }
    }

    public void display() {
        storage.display();
    }
}
