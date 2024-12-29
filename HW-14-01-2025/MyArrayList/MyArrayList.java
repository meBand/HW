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
        if ( index < 0 || index > size ) {
            throw new IndexOutOfBoundsException();
        } else {
            addByIndex(index, element);
        }

    }

    /**
     * Adds an element to the end of the list.
     * @param element the element to add
     */
    private void addLast(T element) {
        if (size >= elements.length) {
            int newCapacity = (int) (elements.length * 1.5);
            T[] newArray = createArray(newCapacity);
            System.arraycopy(elements, 0, newArray, size, elements.length);
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
            newArray[size++] = element;
            System.arraycopy(elements, 0, newArray, size, elements.length);
            elements = newArray;
        } else {
            T[] newArray = createArray(elements.length);
            newArray[size++] = element;
            System.arraycopy(elements, 0, newArray, size, elements.length);
            elements = newArray;
        }
    }
    //todo addFirst addLast - вынести метод

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
                addInside(index, element, elements.length);
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
        System.arraycopy(elements, 0, newArray, size, elements.length - index);
        newArray[size++] = element;
        System.arraycopy(elements, elements.length - index + 1,
                newArray, index + 1, elements.length);
        elements = newArray;
    }
}
