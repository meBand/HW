package HW_14_01_25.MyArrayList;

/**
 * MyArrayList is a simple implementation of a dynamic array.
 * It allows for adding, removing, and accessing elements.
 * <p>
 * Methods size, add, get, set, remove, subList
 * <p>
 * P.S. Не реализовывал интерфейсы (избегал копипаста)
 * <p>
 * некоторые методы перегружены в целях более удобного использования
 *
 * @Author meBanda
 */
public class MyArrayList<E> {

    /**
     * array to store the elements of a {@link MyArrayList}
     */
    private E[] elements;

    /**
     * current size of the {@link MyArrayList}
     */
    private int size;

    /**
     * default capacity of a {@link MyArrayList}
     */
    private final int DEFAULT_CAPACITY = 10;

    /**
     * create new array E[]
     *
     * @param capacity initial capacity (should be more than 0)
     * @return new array E[]
     */
    private E[] createArray(int capacity) {
        return (E[]) new Object[capacity];
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
     *
     * @param capacity initial capacity (only positive)
     * @throws IllegalArgumentException when capacity less than 0
     */
    public MyArrayList(int capacity) {
        if (capacity > 0) {
            elements = createArray(capacity);
        } else if (capacity == 0) {
            elements = createArray(DEFAULT_CAPACITY);
        } else {
            throw new IllegalArgumentException("Capacity cannot be less than 1");
        }
    }

    /**
     * returns the size of the {@link MyArrayList}.
     *
     * @return {@link #size}
     */
    public int size() {
        return size;
    }

    /**
     * adds an element to the end of a {@link MyArrayList}.
     *
     * @param element the element to add
     */
    public void add(E element) {
        addLast(element);
    }

    /**
     * adds array of elements to the end of a {@link MyArrayList}.
     *
     * @param elements the array of elements to add
     */
    public void add(E[] elements) {
        for (E e : elements) {
            add(e);
        }
    }

    /**
     * adds an element into the {@link MyArrayList} by index.
     *
     * @param index   index of an element in a {@link MyArrayList}
     * @param element the element to add
     * @throws IndexOutOfBoundsException when index out if bounds
     */
    public void add(int index, E element) {
        checkIndexOutOfBoundsException(index);
        addByIndex(index, element);
    }

    /**
     * adds array of elements into the {@link MyArrayList} by index.
     *
     * @param index   index of an element in a {@link MyArrayList}
     * @param elements the array of elements to add
     * @throws IndexOutOfBoundsException when index out if bounds
     */
    public void add(int index, E[] elements) {
        checkIndexOutOfBoundsException(index);
        for (int i = 0; i < elements.length; i++ ) {
            add(index+i, elements[i]);
        }
    }

    /**
     * adds an element to the end of the {@link MyArrayList}.
     *
     * @param element the element to add
     */
    private void addLast(E element) {
        if (size >= elements.length) {
            int newCapacity = (int) (elements.length * 1.5);
            E[] newArray = createArray(newCapacity);
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
        elements[size++] = element;
    }

    /**
     * adds an element to the beginning of the {@link MyArrayList}.
     *
     * @param element the element to add
     */
    private void addFirst(E element) {
        if (size >= elements.length) {
            int newCapacity = (int) (elements.length * 1.5);
            E[] newArray = createArray(newCapacity);
            newArray[0] = element;
            System.arraycopy(elements, 0, newArray, 1, elements.length);
            elements = newArray;
        } else {
            E[] newArray = createArray(elements.length + 1);
            newArray[0] = element;
            System.arraycopy(elements, 0, newArray, 1, elements.length);
            elements = newArray;
        }
        size++;
    }

    /**
     * adds an element into the {@link MyArrayList} by index.
     *
     * @param index   index of an element in a {@link MyArrayList}
     * @param element the element to add
     */
    private void addByIndex(int index, E element) {
        if (index == size) {
            addLast(element);
        } else if (index == 0) {
            addFirst(element);
        } else {
            if (size >= elements.length) {
                int newCapacity = (int) (elements.length * 1.5);
                addInside(index, element, newCapacity);
            } else {
                addInside(index, element, elements.length + 1);
            }
        }
    }

    /**
     * adds an element into the {@link MyArrayList} by index.
     *
     * @param index   index of an element in a {@link MyArrayList}
     * @param element the element to add
     */
    private void addInside(int index, E element, int capacity) {
        E[] newArray = createArray(capacity);
        System.arraycopy(elements, 0, newArray, 0, index);
        newArray[index] = element;
        System.arraycopy(elements, index,
                newArray, index + 1, elements.length - index);
        elements = newArray;
        size++;
    }

    /**
     * returns the element at the specified position in this list.
     *
     * @param index the index of the element to return
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E get(int index) {
        checkIndexOutOfBoundsException(index);
        return elements[index];
    }

    /**
     * replaces the element at the specified position in the current {@link MyArrayList} with the specified element.
     *
     * @param index   the index of the element to replace
     * @param element the element to be stored at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void set(int index, E element) {
        checkIndexOutOfBoundsException(index);
        elements[index] = element;
    }

    /**
     * removes the element at the specified position in this list.
     *
     * @param index the index of the element to remove
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E remove(int index) {
        checkIndexOutOfBoundsException(index);
        E removedElement = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        return removedElement;
    }

    /**
     * check index for IndexOutOfBoundsException
     *
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
     *
     * @param fromIndex the starting index (inclusive)
     * @param toIndex   the ending index (exclusive)
     * @return a new MyArrayList containing the elements in the specified range
     * @throws IndexOutOfBoundsException if the indices are out of range
     */
    public MyArrayList<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException("fromIndex: " + fromIndex + ", toIndex: " + toIndex + ", Size: " + size);
        }
        MyArrayList<E> subList = new MyArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(elements[i]);
        }
        return subList;
    }
}
