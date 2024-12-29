import java.util.Iterator;

/**
 * MyArrayList is a simple implementation of a dynamic array.
 * It allows for adding, removing, and accessing elements.
 * @Author meBanda
 */
public class MyArrayList<T> {

    /**
     * Array to store the elements
     */
    private T[] elements;

    /**
     * Current size of the list
     */
    private int size;

    /**
     * Default capacity
     */
    private final int DEFAULT_CAPACITY = 10;

    /**
     * Create new array T[]
     * @param capacity initial capacity
     */
    private T[] createArray(int capacity) {
        return (T[]) new Object[capacity];
    }

    /**
     * Default constructor {@link MyArrayList} with no parameters and default(10) initial capacity
     */
    public MyArrayList() {
        elements = createArray(DEFAULT_CAPACITY);
        size = 0;
    }

    /**
     * Constructor with parameterized initial capacity
     * @param capacity initial capacity (only positive)
     */
    public MyArrayList(int capacity) {
        if ( capacity > 0 ) {
            elements = createArray(capacity);
        } else if ( capacity == 0 ) {
            elements = createArray(DEFAULT_CAPACITY);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Adds an element to the end of the list.
     * @param element the element to add
     */
    public void add(T element) {
        addLast(element);
    }

    /**
     * Adds an element to the list by index.
     * @param index
     * @param element the element to add
     */
    public void add(int index, T element) {
        checkIndexOutOfBoundsException(index);
        addByIndex(index, element);
    }

    /**
     * Adds an element to the end of the list.
     * @param element the element to add
     */
    private void addLast(T element) {
        if (size >= elements.length) {
            int newCapacity = (int) (elements.length * 1.5);
            T[] newArray = createArray(newCapacity);
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
        elements[size++] = element;
    }

    /**
     * Adds an element to the start of the list.
     * @param element the element to add
     */
    private void addFirst(T element) {
        if (size >= elements.length) {
            int newCapacity = (int) (elements.length * 1.5);
            T[] newArray = createArray(newCapacity);
            newArray[0] = element;
            System.arraycopy(elements, 0, newArray, 1, elements.length);
            elements = newArray;
        } else {
            T[] newArray = createArray(elements.length+1);
            newArray[0] = element;
            System.arraycopy(elements, 0, newArray, 1, elements.length);
            elements = newArray;
        }
        size++;
    }
    //todo addFirst addLast - вынести общий метод

    /**
     * Adds an element to the list by index.
     * @param index
     * @param element the element to add
     */
    private void addByIndex(int index, T element) {
        if ( index == size ) {
            addLast(element);
        } else if ( index == 0 ) {
            addFirst(element);
        } else {
            if ( size >= elements.length ) {
                int newCapacity = (int) (elements.length * 1.5);
                addInside(index, element, newCapacity);
            } else {
                addInside(index, element, elements.length+1);
            }
        }
    }

    /**
     * Adds an element to the list by index.
     * @param index
     * @param element the element to add
     */
    private void addInside(int index, T element, int capacity) {
        T[] newArray = createArray(capacity);
        System.arraycopy(elements, 0, newArray, 0, index);
        newArray[index] = element;
        System.arraycopy(elements, index,
                newArray, index + 1, elements.length - index);
        elements = newArray;
        size++;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index the index of the element to return
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get(int index) {
        checkIndexOutOfBoundsException(index);
        return (T) elements[index];
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     * @param index the index of the element to replace
     * @param element the element to be stored at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void set(int index, T element) {
        checkIndexOutOfBoundsException(index);
        elements[index] = element;
    }

    /**
     * Removes the element at the specified position in this list.
     * @param index the index of the element to remove
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T remove(int index) {
        checkIndexOutOfBoundsException(index);
        T removedElement = (T) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return removedElement;
    }

    /**
     * Check index for IndexOutOfBoundsException
     * @param index
     * @return {@link IndexOutOfBoundsException}
     */
    private Throwable checkIndexOutOfBoundsException(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return null;
    }
}
