package lists;

/**
 *
 * ©, 2019, Georges Alfaro S.
 *
 * @author Georges Alfaro S.
 * @version 1.0.0
 * @since 2019-10-12
 */
public class SimpleArrayIterator<T> implements Iterator<T> {

    public SimpleArrayIterator(Object[] v, int k0, int k1) {
        this.v = v;
        this.k0 = k0;
        this.k1 = k1;
        this.current = 0;
    }

    @Override
    public boolean hasNext() {
        return current < count();
    }

    @Override
    public T getNext() {
        T r = null;
        if (hasNext()) {
            r = (T) v[(k0 + current) % v.length];
            current++;
        }
        return r;
    }

    private int count() {
        return (k1 - k0 + v.length) % v.length;
    }

    private final Object[] v;
    private final int k0;
    private final int k1;
    private int current;
}
