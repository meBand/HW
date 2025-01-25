package HW_30_01_25.GlobalLibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Global library of books. May exist in a single copy.
 * Is a publisher and can send notifications to subscribers when new books are added
 */
public class GlobalLibrary {
    /**
     * GlobalLibrary instance
     */
    private static GlobalLibrary instance = null;

    /**
     * Collection of the books
     */
    private List<Book> books = new ArrayList<>();

    /**
     * List of the subscribers
     */
    private List<Subscriber> subscribers = new ArrayList<>();

    /**
     * Default constructor {@link GlobalLibrary}
     */
    private GlobalLibrary() {}

    /**
     * Method create check {@link #instance} if null returns new object {@link GlobalLibrary}
     * or if {@link #instance} is not null returns {@link #instance}
     * @return {@link GlobalLibrary}
     */
    public static GlobalLibrary create() {
        if (instance == null) {
            instance = new GlobalLibrary();
        }
        return instance;
    }

    /**
     * Method adds new {@link Book} in {@link #books}
     * and notify all subscribers
     * @param book {@link Book}
     * @method {@link #notifySubscribers}
     */
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Книга '" + book.getTitle() + "' поступила в библиотеку!");
        notifySubscribers(book);
    }

    /**
     * Method returns copy of book from {@link #books} by cell number
     * @param cellNumber index of a cell
     * @return {@link Book}
     */
    public Book getBook(int cellNumber) {
        try {
            return books.get(cellNumber);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ячейка " + cellNumber + " пуста. Доступно " + (books.size()-1) + " ячеек.");
        }
        return null;
    }

    /**
     * Method returns copy of book from {@link #books} by {@link Book#title}
     * @param title {@link Book#title}
     * @return {@link Book}
     */
    public Book getBook(String title) {
        for (Book book : books) {
            if (book.getTitle() == title) {
                return book;
            }
        }
        System.out.println("Книга '" + title + "' не найдена в библиотеке!");
        return null;
    }

    /**
     * Method adds subscriber to {@link #subscribers}
     * @param subscriber {@link Subscriber}
     */
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
        System.out.println(subscriber.getName() + " оформил(а) подписку.");
    }

    /**
     * Method removes subscriber from {@link #subscribers}
     * @param subscriber {@link Subscriber}
     */
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
        System.out.println(subscriber.getName() + " закрыл(а) подписку.");
    }

    /**
     * Method notify subscribers and transmits copy of a {@link Book}
     * @param book {@link Book}
     */
    private void notifySubscribers(Book book) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(book);
        }
    }
}