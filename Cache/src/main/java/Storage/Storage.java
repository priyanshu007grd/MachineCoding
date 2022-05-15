package Storage;

import Exception.*;

public interface Storage<Key,Value> {

    void add(Key key,Value value);
    void remove(Key key);
    Value get(Key key);
    public void display();
}
