package storage;

import java.util.HashMap;

public class UserStorage<Key,Value> extends Storage<Key,Value> {

    public UserStorage(Key id) {
        super(id,new HashMap<>());
    }
}
