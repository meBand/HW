/**
 * MyArrayList is a simple implementation of a dynamic array.
 * It allows for adding, removing, and accessing elements.
 * @Author meBanda
 */
public class MyArrayList<T> {

    /**
     * array to store the elements of a {@link MyArrayList}
     */
    private T[] elements;

    /**
     * current size of the {@link MyArrayList}
     */
    private int size;

    /**
     * default capacity of a {@link MyArrayList}
     */
    private final int DEFAULT_CAPACITY = 10;

    /**
     * create new array T[]
     * @param capacity initial capacity (should be more than 0)
     * @return new array T[]
     */
    private T[] createArray(int capacity) {
        return (T[]) new Object[capacity];
    }

    /**
     * default constructor {@link MyArrayList} with no parameters and {@link #DEFAULT_CAPACITY}
     */
    public MyArrayList() {
        elements = createArray(DEFAULT_CAPACITY);
        size = 0;
    }

    /**
     * constructor with parameterized initial capacity
     * <p>
     * when capacity = 0 - constructor use {@link #DEFAULT_CAPACITY}
     * @param capacity initial capacity (only positive)
     * @throws IllegalArgumentException when capacity < 0
     */
    public MyArrayList(int capacity) {
        if ( capacity > 0 ) {
            elements = createArray(capacity);
        } else if ( capacity == 0 ) {
            elements = createArray(DEFAULT_CAPACITY);
        } else {
            throw new IllegalArgumentException("Capacity cannot be less than 1");
        }
    }

    /**
     * returns the size of the {@link MyArrayList}.
     * @return {@link #size}
     */
    public int size() {
        return size;
    }

    /**
     * adds an element to the end of a {@link MyArrayList}.
     * @param element the element to add
     */
    public void add(T element) {
        addLast(element);
    }

    /**
     * adds an element into the {@link MyArrayList} by index.
     * @param index  index of a element in a {@link MyArrayList}
     * @param element the element to add
     * @throws IndexOutOfBoundsException when index out if bounds
     */
    public void add(int index, T element) {
        checkIndexOutOfBoundsException(index);
        addByIndex(index, element);
    }

    /**
     * adds an element to the end of the {@link MyArrayList}.
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
     * adds an element to the beginning of the {@link MyArrayList}.
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
    //todo addFirst, addLast - по возможности вынести общий метод

    /**
     * adds an element into the {@link MyArrayList} by index.
     * @param index index of an element in a {@link MyArrayList}
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
     * adds an element into the {@link MyArrayList} by index.
     * @param index index of an element in a {@link MyArrayList}
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
     * returns the element at the specified position in this list.
     * @param index the index of the element to return
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get(int index) {
        checkIndexOutOfBoundsException(index);
        return (T) elements[index];
    }

    /**
     * replaces the element at the specified position in the current {@link MyArrayList} with the specified element.
     * @param index the index of the element to replace
     * @param element the element to be stored at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void set(int index, T element) {
        checkIndexOutOfBoundsException(index);
        elements[index] = element;
    }

    /**
     * removes the element at the specified position in this list.
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
     * check index for IndexOutOfBoundsException
     * @param index
     * @return {@link IndexOutOfBoundsException}
     */
    private Throwable checkIndexOutOfBoundsException(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return null;
    }

    /**
     * returns a sublist from the specified range.
     * @param fromIndex the starting index (inclusive)
     * @param toIndex the ending index (exclusive)
     * @return a new MyArrayList containing the elements in the specified range
     * @throws IndexOutOfBoundsException if the indices are out of range
     */
    public MyArrayList<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("fromIndex: " + fromIndex + ", toIndex: " + toIndex + ", Size: " + size);
        }
        MyArrayList<T> subList = new MyArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add((T) elements[i]);
        }
        return subList;
    }

    //todo по возможности докинуть addAll, removeAll
}
