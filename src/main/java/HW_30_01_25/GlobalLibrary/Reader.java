package HW_30_01_25.GlobalLibrary;

import java.util.ArrayList;
import java.util.List;

public class Reader implements Subscriber {
    private String name;
    private List<Book> books = new ArrayList<>();

    public Reader(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Book book) {
        books.add(book);
        System.out.println(name + ": добавил(а) книгу '" + book.getName() + "' в свою коллекцию.");
    }
}
