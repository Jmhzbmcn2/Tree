package homework7.ex_1;

public interface ListInterface<T> extends Iterable<T> {
    void add(T data);
    T get(int i);
    void set(int i, T data);
    boolean isContain(T data);
    int size();
    boolean isEmpty();
}
