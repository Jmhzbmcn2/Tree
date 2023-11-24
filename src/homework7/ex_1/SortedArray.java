package homework7.ex_1;


import java.util.Iterator;

public class SortedArray<T extends Comparable<T>> implements ListInterface<T> {
    private T[] array;
    private int size = 0;
    private int defaultSize = 0;

    public SortedArray(){
        this(100);
    }

    public SortedArray(int capacity){
        if(capacity<0) throw new IllegalArgumentException("Capacity cannot be negative: "+ capacity);
        this.defaultSize = capacity;
        array = (T[]) new Comparable[capacity];
    }

    @Override
    public void add(T data) {
        if (size() >= defaultSize) {
            throw new ArrayIndexOutOfBoundsException("Queue is full!");
        }
        if (size() == 0) {
            array[0] = data;
        } else {
            int index = size();
            for (int i = 0; i < size(); i++) {
                if (array[i].compareTo(data) > 0){
                    index = i;
                    break;
                }
            }
            for (int i = size() - 1; i >= index; i--) {
                array[i + 1] = array[i];
            }
            array[index] = data;
        }
        size++;
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
        if(isEmpty()) return "[]";
        else{
            StringBuilder sb = new StringBuilder(size);
            sb.append("[");
            for(int i = 0; i< size -1; i++){
                sb.append(array[i]).append(",");
            }
            sb.append(array[size-1]).append("]");
            return sb.toString();
        }
    }
}
