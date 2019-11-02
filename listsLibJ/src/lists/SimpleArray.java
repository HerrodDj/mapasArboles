package lists;

/**
 *
 * ©, 2019, Georges Alfaro S.
 *
 * @author Georges Alfaro S.
 * @version 1.0.1
 * @since 2019-08-12
 */
public class SimpleArray<T> extends AbstractList<T> {

    public SimpleArray(int n) {
        this.v = new Object[n + 1];
        this.k0 = this.k1 = 0;
    }

    public SimpleArray() {
        this(DEFAULT_ARRAY_SIZE);
    }

    @Override
    public int count() {
        return (k1 - k0 + v.length) % v.length;
    }

    public boolean canAdd() {
        return count() < (v.length - 1);
    }

    public int maxSize() {
        return v.length - 1;
    }

    @Override
    public T getFirst() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T getLast() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addFirst(T x) {
        if (canAdd()) {
            k0 = (k0 + v.length - 1) % v.length;
            v[k0] = x;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void addLast(T x) {
        if (canAdd()) {
            v[k1] = x;
            k1 = (k1 + 1) % v.length;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T removeFirst() {
        if (!isEmpty()) {
            T r = (T) v[k0];
            k0 = (k0 + 1) % v.length;
            return r;
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public T removeLast() {
        if (!isEmpty()) {
            k1 = (k1 + v.length - 1) % v.length;
            T r = (T) v[k1];
            return r;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T get(int position) {
        if (position < count) {
            return (T) v[position];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("[");
        for (int i = 0; i < count(); i++) {
            r.append(String.format("%s", v[(k0 + i) % v.length]));
            if (i < (count() - 1)) {
                r.append(", ");
            }
        }
        r.append("]");
        return r.toString();
    }

    @Override
    public Iterator<T> getIterator() {
        throw new UnsupportedOperationException();
    }

    public static final int DEFAULT_ARRAY_SIZE = 128;
    private Object[] v;
    private int k0;
    private int k1;
}
