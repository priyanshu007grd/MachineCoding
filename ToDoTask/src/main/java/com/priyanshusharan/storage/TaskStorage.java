package com.priyanshusharan.storage;

import lombok.ToString;

import java.util.*;

@ToString
public class TaskStorage<Key,Value> extends Storage<Key, Value>{

    public TaskStorage(Key id) {
        super(id,new HashMap<>());
    }
}
