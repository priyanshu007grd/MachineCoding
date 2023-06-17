package com.priyanshusharan.storage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public abstract class Storage<Key,Value> {
    Key id;
    Map<Key,Value> data;

    public Value get(Key key) {
        if(!data.containsKey(key)) throw new RuntimeException("Key Not Found");
        return  data.get(key);
    }

    public void add(Key key,Value value) {
        if(data.containsKey(key)) throw new RuntimeException("Key already added");
        data.put(key,value);
    }

    public void update(Key key,Value value) {
        if(!data.containsKey(key)) throw new RuntimeException("Key not Found!");
        data.put(key,value);
    }

    public void upsert(Key key,Value value) {
        data.put(key,value);
    }

    public Key getKey() {
        return id;
    }

    public void details() {
        System.out.println(data);
    }
}
