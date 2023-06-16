package storage;

import java.util.HashMap;
import java.util.Map;

public class UserAccountStorage<Key,Value> extends Storage<Key,Value> {

    public UserAccountStorage() {
        super(new HashMap<>());
    }

    public void upsert(Key key, Value value) {
        this.data.put(key,value);
    }
}
