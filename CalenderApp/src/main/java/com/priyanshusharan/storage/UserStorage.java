package com.priyanshusharan.storage;

import java.util.HashMap;

public class UserStorage<Key,Value> extends Storage<Key,Value> {

    public UserStorage(Key key) {
        super(key,new HashMap<>());
    }
}
