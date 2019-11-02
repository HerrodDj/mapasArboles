package lists;

/**
 *
 * ©, 2019, Georges Alfaro S.
 *
 * @author Georges Alfaro S.
 * @version 1.0.1
 * @since 2019-08-12
 */
public interface Stack<T> {

    boolean isEmpty();

    int count();

    T top();

    T pop();

    void push(T x);

    T get(int n);

}
