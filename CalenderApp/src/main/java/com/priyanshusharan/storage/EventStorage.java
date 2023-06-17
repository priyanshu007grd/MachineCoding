package com.priyanshusharan.storage;

import java.util.HashMap;

public class EventStorage<Key,Value> extends Storage<Key,Value> {

    public EventStorage(Key key) {
        super(key,new HashMap<>());
    }
}
