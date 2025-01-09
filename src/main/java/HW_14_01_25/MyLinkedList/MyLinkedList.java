package HW_14_01_25.MyLinkedList;

/**
 * MyLinkedList is a simple implementation of linked list.
 * It allows for adding, removing, and accessing elements.
 *
 * @Author meBanda
 */
public class MyLinkedList<T> {

    /**
     * first element of a {@link MyLinkedList}
     */
    private Node<T> head;

    /**
     * returns first element of a {@link MyLinkedList}
     *
     * @return {@link Node}
     */
    public Node<T> head() {
        return head;
    }

    /**
     * last element of a {@link MyLinkedList}
     */
    private Node<T> tail;

    /**
     * returns last element of a {@link MyLinkedList}
     *
     * @return {@link Node}
     */
    public Node<T> tail() {
        return tail;
    }

    /**
     * {@link MyLinkedList} size
     */
    private int size;

    /**
     * returns the size of the {@link MyLinkedList}
     *
     * @return {@link #size}
     */
    public int size() {
        return size;
    }

    /**
     * default constructor of the {@link MyLinkedList}
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Element (node) of a {@link MyLinkedList}
     */
    private static class Node<T> {
        /**
         * data of the {@link Node}
         */
        T data;

        /**
         * link to the next element of the linked list {@link MyLinkedList}
         */
        Node<T> next;

        /**
         * link to the previous element of the linked list {@link MyLinkedList}
         */
        Node<T> prev;

        /**
         * default constructor of the {@link Node}
         *
         * @param data {@link #data}
         */
        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    /**
     * adds new {@link Node} to the end of a {@link MyLinkedList}
     *
     * @param data {@link Node#data}
     */
    public void add(T data) {
        addLast(data);
    }

    /**
     * adds array of new {@link Node} to the end of a {@link MyLinkedList}
     *
     * @param data array of {@link Node#data}
     */
    public void add(T[] data) {
        for (T e : data) {
            addLast(e);
        }
    }

    /**
     * adds new {@link Node} to the {@link MyLinkedList} by index
     *
     * @param index index of a {@link Node} in a {@link MyLinkedList}
     * @param data  {@link Node#data}
     * @throws IndexOutOfBoundsException when index out of range
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
     * adds array of new {@link Node} to the {@link MyLinkedList} by index
     *
     * @param index index of a {@link Node} in a {@link MyLinkedList}
     * @param data  {@link Node#data}
     * @throws IndexOutOfBoundsException when index out of range
     */
    public void add(int index, T[] data) {
        for (int i = 0; i < data.length; i++ ) {
            add(index+i, data[i]);
        }
    }

    /**
     * adds new {@link Node} to the end of a {@link MyLinkedList}
     *
     * @param data {@link Node#data}
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
     * adds new {@link Node} to the beginning of a {@link MyLinkedList}
     *
     * @param data {@link Node#data}
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
     * adds new {@link Node} into the {@link MyLinkedList}
     *
     * @param index index of a {@link Node} in a {@link MyLinkedList}
     * @param data  {@link Node#data}
     */
    private void addInside(int index, T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> indexNode = getNode(index);
        newNode.next = indexNode;
        newNode.prev = indexNode.prev;
        indexNode.prev.next = newNode;
        if (index != size - 1) {
            indexNode.prev = newNode;
        }
        size++;
    }

    /**
     * returns the data of a {@link Node} in a {@link MyLinkedList} by index
     *
     * @param index index of a {@link Node} in a {@link MyLinkedList}
     * @return {@link Node#data}
     */
    public T get(int index) {
        return getNode(index).data;
    }

    /**
     * returns the data of a {@link Node} in a {@link MyLinkedList}
     *
     * @param node {@link Node}
     * @return {@link Node#data}
     */
    public T get(Node<T> node) {
        return node.data;
    }

    /**
     * returns the next node data of a {@link Node} in a {@link MyLinkedList}
     *
     * @param node {@link Node}
     * @return {@link Node#data}
     */
    public T getNext(Node<T> node) {
        return node.next.data;
    }

    /**
     * returns the prev node data of a {@link Node} in a {@link MyLinkedList}
     *
     * @param node {@link Node}
     * @return {@link Node#data}
     */
    public T getPrev(Node<T> node) {
        return node.prev.data;
    }

    /**
     * sets new data for a {@link Node} in a {@link MyLinkedList} by index
     * <p>
     * returns old data of a {@link Node}
     *
     * @param index index of a {@link Node} in a {@link MyLinkedList}
     * @param data  {@link Node#data}
     * @return {@link Node#data} before setting new data
     */
    public T set(int index, T data) {
        Node<T> current = getNode(index);
        T oldData = current.data;
        current.data = data;
        return oldData;
    }

    /**
     * returns a {@link Node} in a {@link MyLinkedList} by index
     *
     * @param index index of a {@link Node} in a {@link MyLinkedList}
     * @return {@link Node}
     * @throws IndexOutOfBoundsException when index out of range
     */
    public Node<T> getNode(int index) {
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
     * removes a {@link Node} from a {@link MyLinkedList} by index
     * <p>
     * return data of a removed node
     *
     * @param index index of a {@link Node} in a {@link MyLinkedList}
     * @return {@link Node#data} of a removed {@link Node}
     */
    public T remove(int index) {
        Node<T> rmNode = getNode(index);
        if (rmNode == head) {
            if ( size() > 1 ) {
                head = rmNode.next;
                head.prev = null;
            } else {
                head = null;
            }
        } else if (rmNode == tail) {
            if ( size() > 1 ) {
                tail = rmNode.prev;
                tail.next = null;
            } else {
                tail = null;
            }
        } else {
            rmNode.next.prev = rmNode.prev;
            rmNode.prev.next = rmNode.next;
        }
        size--;
        return rmNode.data;
    }

    /**
     * removes all {@link Node} from a {@link MyLinkedList}
     */
    public void removeAll() {
        int size = size();
        for (int i = 0; i < size; i++) {
            remove(0);
        }
    }

    /**
     * returns sublist based on an existing one within a given range
     *
     * @param startIndex start index of range (inclusive)
     * @param endIndex   end index of range (exclusive)
     * @return {@link MyLinkedList}
     * @throws IndexOutOfBoundsException when range is not valid
     */
    public MyLinkedList<T> subList(int startIndex, int endIndex) {
        if (!checkRange(startIndex, endIndex)) {
            throw new IndexOutOfBoundsException("Range is not valid: ( startIndex = " + startIndex +
                    " endIndex = " + endIndex);
        }
        MyLinkedList<T> subList = new MyLinkedList<>();
        for (int i = startIndex; i < endIndex; i++) {
            subList.add(this.get(i));
        }
        return subList;
    }

    /**
     * checks the validity of a range for a current {@link MyLinkedList}
     *
     * @param startIndex start index of range (inclusive)
     * @param endIndex   end index of range (exclusive)
     * @return true if range is valid
     */
    private boolean checkRange(int startIndex, int endIndex) {
        return startIndex >= 0 && startIndex < size && endIndex >= startIndex;
    }

    //todo javaDoc, по возможности докинуть addAll, getAll, removeAll
}
