package storage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Storage<Key,Value> {

    Key id;
    Map<Key,Value> data;

    public Storage(Map<Key, Value> data) {
        this.data = data;
    }

    public Value get(Key key) {
        if(!this.data.containsKey(key)) throw new RuntimeException("Key not found");
        return this.data.get(key);
    }

    public void add(Key key, Value value) {
        if(this.data.containsKey(key)) throw new RuntimeException("Key already exit");
        this.data.put(key,value);
        this.id = key;
    }

    public void remove(Key key) {
        if(!this.data.containsKey(key)) throw new RuntimeException("Key not found");
        this.data.remove(key);
    }

    public void update(Key key, Value value) {
        if(!this.data.containsKey(key)) throw new RuntimeException("Key not found");
        this.data.put(key,value);
    }

    public Key getKey() {
        return id;
    }

    public void display() {
        System.out.println(this.data);
    }
}
