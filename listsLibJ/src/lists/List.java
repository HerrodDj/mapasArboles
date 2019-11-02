package lists;

/**
 *
 * ©, 2019, Georges Alfaro S.
 *
 * @author Georges Alfaro S.
 * @version 1.0.1
 * @since 2019-08-12
 */
public interface List<T> {

    public void clear();

    public T getFirst();

    public T getLast();

    public void addFirst(T x);

    public void addLast(T x);

    public T removeFirst();

    public T removeLast();

    public T get(int position);

    public Iterator<T> getIterator();

}
