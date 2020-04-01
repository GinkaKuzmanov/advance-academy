package bg.baradvance.interfaces;

public interface Repository<K,V> {
    /**
     * Saves the data in structure.
     * @param unit
     * Training OOP principles.(for testing)
     */
    void save(V unit);

    V remove(K id);

    V fetch(K id);

    boolean contains(K tableNumber);


}
