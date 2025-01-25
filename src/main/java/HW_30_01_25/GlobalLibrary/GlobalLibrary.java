package HW_30_01_25.GlobalLibrary;

import java.util.ArrayList;
import java.util.List;

public class GlobalLibrary {
    private static GlobalLibrary instance = null;
    private List<Book> books = new ArrayList<>();
    private List<Subscriber> subscribers = new ArrayList<>();

    private GlobalLibrary() {}

    public static GlobalLibrary create() {
        if (instance == null) {
            instance = new GlobalLibrary();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Книга '" + book.getTitle() + "' поступила в библиотеку!");
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
            if (book.getTitle() == name) {
                return book;
            }
        }
        System.out.println("Книга '" + name + "' не найдена в библиотеке!");
        return null;
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
        System.out.println(subscriber.getName() + " оформил(а) подписку.");
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
        System.out.println(subscriber.getName() + " закрыл(а) подписку.");
    }

    private void notifySubscribers(Book book) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(book);
        }
    }
}