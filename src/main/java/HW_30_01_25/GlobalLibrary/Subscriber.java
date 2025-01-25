package HW_30_01_25.GlobalLibrary;

/**
 * Interface Subscriber
 */
public interface Subscriber {
    /**
     * Method updates the subscriber state when a new book arrives
     * @param book {@link Book}
     */
    void update(Book book);

    /**
     * Method returns name subscriber
     * @return String name
     */
    String getName();
}
