import Cache.Cache;


public class CacheMain<Key,Value> {

    public static void main(String[] args) {

        Cache<Integer,String> cache = new Cache<Integer, String>(3);

        cache.put(1,"ram");
        cache.display();
        cache.put(2,"shyam");
        cache.display();
        System.out.println(cache.get(1));
        cache.put(3,"ghanshyam");
        cache.display();
        cache.put(5,"adas");
        cache.display();

    }
}
