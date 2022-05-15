package EvictionPolicy;

public interface EvictionPolicy<Key> {

    void keyAccessed(Key key);
    Key evictKey() throws Exception;
}
