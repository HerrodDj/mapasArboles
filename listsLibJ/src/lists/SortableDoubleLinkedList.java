package lists;

/**
 *
 * ©, 2019, Georges Alfaro S.
 *
 * @author Georges Alfaro S.
 * @version 1.0.1
 * @since 2019-09-25
 */
public class SortableDoubleLinkedList<T extends Comparable>
        extends DoubleLinkedList<T> {

    public T add(T x) {
        if (isEmpty()) {
            addFirst(x);
        } else {
            DLink<T> cursor = first;
            while ((cursor.getInfo().compareTo(x) < 0) && (cursor.getNext() != null)) {
                cursor = cursor.getNext();
            }
            DLink<T> tmp = new DLink(x, cursor, cursor.getNext());
            cursor.setNext(tmp);
            if (tmp.getNext() != null) {
                tmp.getNext().setPrevious(tmp);
            }
        }
        return x;
    }

    public void sort() {
        if (!isEmpty()) {
            DLink<T> cursor = first;
            while (cursor.getNext() != null) {

                if (cursor.getInfo().compareTo(cursor.getNext().getInfo()) <= 0) {
                    cursor = cursor.getNext();
                } else {

                    T x = cursor.getNext().getInfo();
                    cursor.setNext(cursor.getNext().getNext());
                    if (cursor.getNext() == null) {
                        last = cursor;
                    }

                    if (x.compareTo(first.getInfo()) < 0) {
                        addFirst(x);
                    } else {
                        DLink<T> pos = first;
                        while (pos.getNext().getInfo().compareTo(x) < 0) {
                            pos = pos.getNext();
                        }
                        DLink<T> t = new DLink<>(x, pos, pos.getNext());
                        pos.setNext(t);
                        t.getNext().setPrevious(t);
                    }
                }
            }
        }
    }

}
