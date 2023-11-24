package homework7.ex_1;

import java.util.Iterator;

public class UnsortedArray<T> implements ListInterface<T>{
    private T[] array;
    private int size = 0;
    private int defaultSize = 0;

    public UnsortedArray() {
        this(100);
    }

    public UnsortedArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity cannot be negative: " + capacity);
        this.defaultSize = capacity;
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T data) {
        if (size >= defaultSize - 1) {
            if (defaultSize == 0) {
                defaultSize = 1;
            } else {
                defaultSize *= 2;
            }
            T[] newArr = (T[]) new Object[defaultSize];
            for (int i = 0; i < array.length; i++) {
                newArr[i] = array[i];
            }
            array = newArr;
        }
        array[size++] = data;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= size) {
            return null;
        }
        return array[i];
    }

    @Override
    public void set(int i, T data) {
        if (i < 0 || i >= size) {
            return;
        }
        array[i] = data;
    }

    @Override
    public boolean isContain(T data) {
        return indexOf(data) != -1;
    }

    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (object == null) {
                if (array[i] == null) {
                    return i;
                }
            } else {
                if (object.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return array[index++];
            }
        };
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        else {
            StringBuilder sb = new StringBuilder(size);
            sb.append("[");
            for (int i = 0; i < size - 1; i++) {
                sb.append(array[i]).append(",");
            }
            sb.append(array[size - 1]).append("]");
            return sb.toString();
        }
    }

}
