package com.priyanshusharan.storage;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class CalenderStorage<Key,Value> extends Storage<Key,Value> {
    public CalenderStorage(Key key) {
        super(key,new HashMap<>());
    }
}
