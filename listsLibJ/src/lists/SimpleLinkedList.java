package lists;

/**
 *
 * ©, 2019, Georges Alfaro S.
 *
 * @author Georges Alfaro S.
 * @version 1.0.1
 * @since 2019-08-12
 */
public class SimpleLinkedList<T> extends AbstractList<T>{

    public SimpleLinkedList() {
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
        first = new Link<>(x, first);
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
            last.setNext(new Link<>(x));
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
                Link<T> cursor = first;
                while (cursor.getNext() != last) {
                    cursor = cursor.getNext();
                }
                cursor.setNext(null);
                last = cursor;
            }
            count--;
        }
        return r;
    }

    @Override
    public T get(int position) {
        if (position < count) {
            Link<T> cursor = first;
            int i = 0;
            while (i < position) {
                cursor = cursor.getNext();
                i++;
            }
            return cursor.getInfo();
        }
        throw new IndexOutOfBoundsException();
    }    

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("[");
        Link cursor = first;
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
        return new SimpleLinkedListIterator<>(first);
    }

    Link<T> first, last;

    @Override
    public T get(T info) {
        if (count > 0) {
            Link<T> cursor = first;
            int i = 0;
            while (i < count && !info.equals(cursor.getInfo())) {
                cursor = cursor.getNext();
                i++;
            }
            return cursor.getInfo();
        }
        throw new IndexOutOfBoundsException();
    }
}

class Link<T> {

    public Link(T info, Link<T> next) {
        this.info = info;
        this.next = next;
    }

    public Link(T info) {
        this(info, null);
    }

    public T getInfo() {
        return info;
    }

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    private T info;
    private Link<T> next;
}
