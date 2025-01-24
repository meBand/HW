package HW_30_01_25.GlobalLibrary;

public class Book {
    private String name;
    private Genre genre;

    public Book(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public Genre getGenre() {
        return genre;
    }
}
