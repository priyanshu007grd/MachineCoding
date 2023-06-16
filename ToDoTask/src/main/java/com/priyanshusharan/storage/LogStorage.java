package com.priyanshusharan.storage;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@ToString
@Getter
public class LogStorage<Key,Value> extends Storage<Key, Value> {


    public LogStorage() {
        super(new TreeMap<>());
    }

    public List<Value> getAll() {
        return data.entrySet().stream().map(e->e.getValue()).toList();
    }
}
