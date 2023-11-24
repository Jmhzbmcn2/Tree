package homework7.ex_1;

public class UnsortedLinkedList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public Node<T> getHead() {
        return head;
    }

    public void addBot(T data) {
        if (isEmpty()) head = tail = new Node<>(data, null);
        else {
            Node<T> newNode = new Node<>(data,null);
            tail.setNext(newNode);
            tail = newNode;

        }
        size++;
    }

    public void addTop(T data) {
        Node<T> newNode = new Node<>(data, head);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setNext(head);
            newNode = head;
        }
        size++;
    }

    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<T> currentNode = head;
        for (int index = 0; index < i; index++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getData();
    }

    public void set(int i, T data) {
        if (i < 0 || i >= size) {
//            throw new IndexOutOfBoundsException("Index out of bounds");
            return;
        } else {
            Node<T> currentNode = head;
            for (int index = 0; index < i; index++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setData(data);
        }
    }

    public boolean isContain(T data) {
        Node<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.getData().equals(data)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T removeTop() {
        if (isEmpty()) {
//            throw new RuntimeException("Empty linked list!");
            return null;
        }
        T data = head.getData();
        head = head.getNext();
        size--;
        if (isEmpty()) tail = null;
        return data;
    }

    public T removeBot() {
        if (isEmpty()) {
//            throw new NoSuchElementException("Empty linked list!");
            return null;
        }
        if (size() == 1) {
            T data = head.getData();
            head = tail = null;
            size = 0;
            return data;
        }
        Node<T> currentNode = head;
        while (currentNode.getNext() != tail) {
            currentNode = currentNode.getNext();
        }
        T data = currentNode.getNext().getData();
        currentNode.setNext(null);
        tail = currentNode;
        size--;
        return data;
    }

    public void remove(T data) {
        if (isEmpty()) throw new IllegalThreadStateException("Empty linked list!");
        if (head.getData().equals(data)) {
            removeTop();
            return;
        }
        Node<T> currentNode = head;
        while (currentNode.getNext() != null || !currentNode.getNext().getData().equals(data)) {
            currentNode = currentNode.getNext();
        }

        if (currentNode.getNext() != null) {
            currentNode.setNext(currentNode.getNext().getNext());
            size--;
        }

        if (currentNode.getNext() == null) {
            return;
        }

    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        else {
            StringBuilder sb = new StringBuilder(size);
            sb.append("[");

            Node<T> currentNode = head;
            while (currentNode != null) {
                sb.append(currentNode.getData());
                if(currentNode.getNext() != null) sb.append(",");
                currentNode = currentNode.getNext();
            }
            sb.append("]");
            return sb.toString();
        }
    }

}
