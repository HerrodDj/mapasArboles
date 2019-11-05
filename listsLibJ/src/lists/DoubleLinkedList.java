package lists;

/**
 *
 * ©, 2019, Georges Alfaro S.
 *
 * @author Georges Alfaro S.
 * @version 1.0.0
 * @since 2019-08-30
 */
public class DoubleLinkedList<T> extends AbstractList<T> {

    public DoubleLinkedList() {
        super();
        this.first = this.last = null;
    }

    @Override
    public T getFirst() {
        return isEmpty() ? null : first.getInfo();
    }

    @Override
    public T getLast() {
        return isEmpty() ? null : last.getInfo();
    }

    @Override
    public void addFirst(T x) {
        first = new DLink<>(x, null, first);
        if (first.getNext() != null) {
            first.getNext().setPrevious(first);
        }
        if (last == null) {
            last = first;
        }
        count++;
    }

    @Override
    public void addLast(T x) {
        if (isEmpty()) {
            addFirst(x);
        } else {
            last.setNext(new DLink<>(x, last, null));
            last = last.getNext();
            count++;
        }
    }

    @Override
    public T removeFirst() {
        T r = null;
        if (!isEmpty()) {
            r = first.getInfo();
            first = first.getNext();
            if (first != null) {
                first.setPrevious(null);
            }
            if (first == null) {
                last = null;
            }
            count--;
        }
        return r;
    }

    @Override
    public T removeLast() {
        T r = null;
        if (!isEmpty()) {
            r = last.getInfo();
            if (first == last) {
                first = last = null;
            } else {
                last = last.getPrevious();
                last.setNext(null);
            }
            count--;
        }
        return r;
    }

    @Override
    public T get(int position) {
        if (position < count) {
            DLink<T> cursor = first;
            int i = 0;
            while (i < position) {
                cursor = cursor.getNext();
                i++;
            }
            return cursor.getInfo();
        }
        throw new IndexOutOfBoundsException();
    }

    void insertBefore(DLink<T> current, T x) {
        if (current == first) {
            addFirst(x);
        } else {
            DLink<T> tmp = new DLink<>(x, current.getPrevious(), current);
            tmp.getPrevious().setNext(tmp);
            tmp.getNext().setPrevious(tmp);
            count++;
        }
    }

    void insertAfter(DLink<T> current, T x) {
        if (current == last) {
            addLast(x);
        } else {
            DLink<T> tmp = new DLink<>(x, current, current.getNext());
            tmp.getPrevious().setNext(tmp);
            tmp.getNext().setPrevious(tmp);
            count++;
        }
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("[");
        DLink cursor = first;
        while (cursor != null) {
            r.append(String.format("%s", cursor.getInfo()));
            cursor = cursor.getNext();
            if (cursor != null) {
                r.append(", ");
            }
        }
        r.append("]");
        return r.toString();
    }

    @Override
    public Iterator<T> getIterator() {
        return new DoubleLinkedListIterator<>(first);
    }

    DLink<T> first, last;

    @Override
    public T get(T info) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}

class DLink<T> {

    public DLink(T info, DLink<T> prev, DLink<T> next) {
        this.info = info;
        this.prev = prev;
        this.next = next;
    }

    public DLink(T info) {
        this(info, null, null);
    }

    public T getInfo() {
        return info;
    }

    public DLink<T> getPrevious() {
        return prev;
    }

    public void setPrevious(DLink<T> prev) {
        this.prev = prev;
    }

    public DLink<T> getNext() {
        return next;
    }

    public void setNext(DLink<T> next) {
        this.next = next;
    }

    private T info;
    private DLink<T> prev;
    private DLink<T> next;
}
