package HW_30_01_25.GlobalLibrary;

public class main {
    public static void main(String[] args) {
        Book book1 = new Book("Шерлок Холмс", Genre.MYSTERY);
        Book book2 = new Book("Преступление и наказание", Genre.DRAMA);
        Book book3 = new Book("Паттерны проектирование", Genre.NONFICTION);
        Book book4 = new Book("1984", Genre.SCIENCE);
        Book book5 = new Book("Властелин колец", Genre.FANTASY);

        ManuscriptBook manuscriptBook1 = new ManuscriptBook("Зеленый свет", Genre.AUTOBIOGRAPHY);
        ManuscriptBook manuscriptBook2 = new ManuscriptBook("Евгений Онегин", Genre.POETRY);
        ManuscriptBook manuscriptBook3 = new ManuscriptBook("Институт", Genre.THRILLER);

        ManuscriptBookAdapter adaptManuscriptBook1 = new ManuscriptBookAdapter(manuscriptBook1);
        ManuscriptBookAdapter adaptManuscriptBook2 = new ManuscriptBookAdapter(manuscriptBook2);
        ManuscriptBookAdapter adaptManuscriptBook3 = new ManuscriptBookAdapter(manuscriptBook3);

        Reader reader1 = new Reader("Петр");
        Reader reader2 = new Reader("Василий");
        Reader reader3 = new Reader("Евлантий");
        Reader reader4 = new Reader("Людмила");

        GlobalLibrary library = GlobalLibrary.create();

        library.addBook(book1);
        library.addBook(book2);
        System.out.println();

        library.subscribe(reader1);
        library.subscribe(reader2);
        library.subscribe(reader3);
        library.subscribe(reader4);
        System.out.println();

        GlobalLibrary newLibrary = GlobalLibrary.create();
        
        newLibrary.addBook(book3);
        newLibrary.addBook(book4);
        newLibrary.addBook(book5);
        System.out.println();

        newLibrary.unsubscribe(reader1);
        newLibrary.unsubscribe(reader2);
        System.out.println();

        //library.addBook(manuscriptBook1); - не скомпилируется
        library.addBook(adaptManuscriptBook1);
        library.addBook(adaptManuscriptBook2);
        library.addBook(adaptManuscriptBook3);
    }
}
