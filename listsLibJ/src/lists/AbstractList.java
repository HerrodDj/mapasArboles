package lists;

/**
 *
 * ©, 2019, Georges Alfaro S.
 *
 * @author Georges Alfaro S.
 * @version 1.0.1
 * @since 2019-08-12
 */
public abstract class AbstractList<T> implements Stack<T>, Queue<T>, List<T> {

    public AbstractList() {
        this.count = 0;
    }

    @Override
    public boolean isEmpty() {
        return count() == 0;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            removeFirst();
        }
    }

    @Override
    public T top() {
        return getFirst();
    }

    @Override
    public T pop() {
        return removeFirst();
    }

    @Override
    public void push(T x) {
        addFirst(x);
    }

    @Override
    public T front() {
        return getFirst();
    }

    @Override
    public T dequeue() {
        return removeFirst();
    }

    @Override
    public void enqueue(T x) {
        addLast(x);
    }

    @Override
    public void append(List<T> c) {
        Iterator<T> i = c.getIterator();
        while (i.hasNext()) {
            addLast(i.getNext());
        }
    }

    protected int count;
}
