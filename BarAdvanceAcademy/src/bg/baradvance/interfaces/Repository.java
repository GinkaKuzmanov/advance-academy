package bg.baradvance.interfaces;

public interface Repository<T,K> {

    void add(T unit);

    T remove(K id);

    T get(K id);


}
