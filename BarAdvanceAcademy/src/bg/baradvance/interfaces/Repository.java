package bg.baradvance.interfaces;

public interface Repository<T,K> {
    /**
     * Saves the data in structure.
     * @param unit
     * Training OOP principles.(for testing)
     */
    void save(T unit);

    T remove(K id);

    T fetch(K id);

    boolean contains(K tableNumber);


}
