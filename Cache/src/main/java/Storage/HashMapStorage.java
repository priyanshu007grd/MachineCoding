package Storage;

import java.util.HashMap;
import java.util.Map;
import Exception.*;

public class HashMapStorage<Key, Value> implements Storage<Key, Value>{

    Map<Key,Value> storageM;
    Integer capacity;

    public HashMapStorage(Integer capacity) {
        this.capacity = capacity;
        storageM = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) {
        if(storageM.size()>=capacity) throw new StorageFullException("Storage full");
        storageM.putIfAbsent(key,value);
    }

    @Override
    public void remove(Key key) {
        if(!storageM.containsKey(key))  throw new KeyNotFound("key not found");
        storageM.remove(key);
    }

    @Override
    public Value get(Key key) {
        if(!storageM.containsKey(key))  throw new KeyNotFound("key not found");
        return storageM.get(key);
    }

    @Override
    public void display() {

        for (Map.Entry mapElement : storageM.entrySet()) {
            System.out.println("Key = " + mapElement.getKey() + " : value = " +mapElement.getValue() );
        }
    }
}
