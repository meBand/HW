/**
 * MyLinkedList is a simple implementation of linked list.
 * It allows for adding, removing, and accessing elements.
 * @Author meBanda
 */
public class MyLinkedList<T> {

    /**
     *
     */
    private Node<T> head;

    /**
     *
     */
    private Node<T> tail;

    /**
     *
     */
    private int size;

    /**
     *
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Class
     */
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     *
     */
    public void add(T data) {
        addLast(data);
    }

    /**
     *
     */
    public void add(int index, T data) {
        if (index == size) {
            addLast(data);
        } else if (index == 0) {
            addFirst(data);
        } else if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index + "\n" +
                    "try yourList.add(data) method to insert at the end of the list");
        } else {
            addInside(index, data);
        }
    }

    /**
     *
     */
    private void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    /**
     *
     */
    private void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     *
     */
    private void addInside(int index, T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> indexNode = getNode(index);
        newNode.next = indexNode;
        newNode.prev = indexNode.prev;
        indexNode.prev.next = newNode;
        indexNode.next.prev = newNode;
    }

    /**
     *
     */
    public T get(int index) {
        return getNode(index).data;
    }

    /**
     *
     */
    public T set(int index, T data) {
        Node<T> current = getNode(index);
        T oldData = current.data;
        current.data = data;
        return oldData;
    }

    /**
     *
     */
    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     *
     */
    public T remove(int index) {
        Node<T> rmNode = getNode(index);
        if (rmNode == head) {
            head = rmNode.next;
            head.prev = null;
        } else if (rmNode == tail) {
            tail = rmNode.prev;
            tail.next = null;
        } else {
            rmNode.next.prev = rmNode.prev;
            rmNode.prev.next = rmNode.next;
        }
        size--;
        return rmNode.data;
    }

    /**
     *
     */
    public MyLinkedList<T> subList(int startIndex, int endIndex) {
        if ( !checkSpan(startIndex, endIndex) ) {
            throw new IndexOutOfBoundsException("Interval is not valid: ( startIndex = " + startIndex +
                    " endIndex = " + endIndex);
        }
        MyLinkedList<T> subList = new MyLinkedList<>();
        for (int i = startIndex; i < endIndex; i++) {
            subList.add( this.get(i) );
        }
        return subList;
    }

    /**
     *
     */
    private boolean checkSpan(int startIndex, int endIndex) {
        return startIndex >= 0 && startIndex < size && endIndex >= startIndex;
    }

    //todo javaDoc, по возможности addAll, removeAll
}
