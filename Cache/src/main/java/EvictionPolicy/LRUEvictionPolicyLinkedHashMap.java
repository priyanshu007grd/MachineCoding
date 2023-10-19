package EvictionPolicy;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class LRUEvictionPolicyLinkedHashMap<Key> implements EvictionPolicy<Key> {
    LinkedHashSet<Key> keyStore;

    public LRUEvictionPolicyLinkedHashMap() {
        this.keyStore=new LinkedHashSet<>();
    }

    @Override
    public void keyAccessed(Key key) {

        if(this.keyStore.contains(key)) {
            this.keyStore.remove(key);
        }
        this.keyStore.add(key);
    }

    @Override
    public Key evictKey() throws Exception {

        if(this.keyStore.isEmpty()) throw new RuntimeException("LRU is empty");
        Key key=this.keyStore.stream().findFirst().get();
        this.keyStore.remove(key);
        return key;
    }
}
