package storage;

import java.util.HashMap;

public class ExpenseStorage<Key,Value> extends Storage<Key,Value> {

    public ExpenseStorage(Key id) {
        super(id,new HashMap<>());
    }
}
