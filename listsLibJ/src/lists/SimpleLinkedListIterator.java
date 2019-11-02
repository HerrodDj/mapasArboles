package lists;

/**
 *
 * ©, 2019, Georges Alfaro S.
 *
 * @author Georges Alfaro S.
 * @version 1.0.1
 * @since 2019-09-30
 */
class SimpleLinkedListIterator<T> implements Iterator {

    public SimpleLinkedListIterator(Link<T> current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T getNext() {
        T r = null;
        if (hasNext()) {
            r = current.getInfo();
            current = current.getNext();
        }
        return r;
    }

    private Link<T> current;
}
