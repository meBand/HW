package HW_30_01_25.GlobalLibrary;

import java.util.ArrayList;
import java.util.List;

public class GlobalLibrary {
    private static GlobalLibrary instance;
    private List<Book> books = new ArrayList<>();
    private List<Subscriber> subscribers = new ArrayList<>();

    private GlobalLibrary() {}

    public static GlobalLibrary getInstance() {
        if (instance == null) {
            instance = new GlobalLibrary();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        notifySubscribers(book);
    }

    public Book getBook(int cellNumber) {
        try {
            return books.get(cellNumber);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ячейка " + cellNumber + " пуста. Доступно " + (books.size()-1) + " ячеек.");
        }
        return null;
    }

    public Book getBook(String name) {
        for (Book book : books) {
            if (book.getName() == name) {
                return book;
            }
        }
        System.out.println("Книга '" + name + "' не найдена в библиотеке!");
        return null;
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    private void notifySubscribers(Book book) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(book);
        }
    }
}