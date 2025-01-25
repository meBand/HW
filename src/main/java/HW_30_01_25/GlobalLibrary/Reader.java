package HW_30_01_25.GlobalLibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Reader implements interface Subscriber
 * Just person who likes to read books
 * Has its own collection of books and can subscribe to library updates
 */
public class Reader implements Subscriber {
    /**
     * Reader name
     */
    private String name;

    /**
     * Readers collection of the books
     */
    private List<Book> books = new ArrayList<>();

    /**
     * Constructor reader
     * @param name {link #name}
     */
    public Reader(String name) {
        this.name = name;
    }

    /**
     * Method returns reader name
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * Method updates the user's collection by adding a new book
     * @param book {@link Book}
     */
    @Override
    public void update(Book book) {
        books.add(book);
        System.out.println(name + ": добавил(а) книгу '" + book.getTitle() + "' в свою коллекцию.");
    }
}
