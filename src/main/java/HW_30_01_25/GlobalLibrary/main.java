package HW_30_01_25.GlobalLibrary;

public class main {
    public static void main(String[] args) {
        //Создаем книги
        Book book1 = new Book("Шерлок Холмс", Genre.MYSTERY);
        Book book2 = new Book("Преступление и наказание", Genre.DRAMA);
        Book book3 = new Book("Паттерны проектирование", Genre.NONFICTION);
        Book book4 = new Book("1984", Genre.SCIENCE);
        Book book5 = new Book("Властелин колец", Genre.FANTASY);

        //Создаем рукописи
        Manuscript manuscript1 = new Manuscript("Зеленый свет", Genre.AUTOBIOGRAPHY);
        Manuscript manuscript2 = new Manuscript("Евгений Онегин", Genre.POETRY);
        Manuscript manuscript3 = new Manuscript("Институт", Genre.THRILLER);

        //Преобразовываем рукописи
        ManuscriptBookAdapter adaptManuscriptBook1 = new ManuscriptBookAdapter(manuscript1);
        ManuscriptBookAdapter adaptManuscriptBook2 = new ManuscriptBookAdapter(manuscript2);
        ManuscriptBookAdapter adaptManuscriptBook3 = new ManuscriptBookAdapter(manuscript3);

        //Создаем читателей
        Reader reader1 = new Reader("Петр");
        Reader reader2 = new Reader("Василий");
        Reader reader3 = new Reader("Евлантий");
        Reader reader4 = new Reader("Людмила");

        //Создаем экземпляр библиотеки
        GlobalLibrary library = GlobalLibrary.create();

        //Добавляем несколько книг
        library.addBook(book1);
        library.addBook(book2);
        System.out.println();

        //Оформляем подписки
        library.subscribe(reader1);
        library.subscribe(reader2);
        library.subscribe(reader3);
        library.subscribe(reader4);
        System.out.println();

        //Пробуем создать еще одну библиотеку
        GlobalLibrary newLibrary = GlobalLibrary.create();

        //Добавляем книги в новую библиотеку
        //но это до сих пор первая библиотека ( обманули получается:) )
        newLibrary.addBook(book3);
        newLibrary.addBook(book4);
        newLibrary.addBook(book5);
        System.out.println();

        //Видимо подписчикам не понравился сервис - решили отписаться
        newLibrary.unsubscribe(reader1);
        newLibrary.unsubscribe(reader2);
        System.out.println();

        //library.addBook(manuscript1); - не скомпилируется

        //Добавляем в хранилище рукописи преобразованные в книги
        library.addBook(adaptManuscriptBook1);
        library.addBook(adaptManuscriptBook2);
        library.addBook(adaptManuscriptBook3);
    }
}
