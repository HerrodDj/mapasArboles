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

    public static <T> AbstractList<T> create(LIST_TYPE type) {
        switch (type) {
            case ARRAY:
                return new SimpleArray<>();
            case LINKED_LIST:
                return new SimpleLinkedList<>();
            case DOUBLE_LINKED_LIST:
                return new DoubleLinkedList<>();
            default:
                throw new IllegalArgumentException();
        }
    }

    public enum LIST_TYPE {
        ARRAY,
        LINKED_LIST,
        DOUBLE_LINKED_LIST
    }

    protected int count;
}
