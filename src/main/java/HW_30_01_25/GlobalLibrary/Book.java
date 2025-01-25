package HW_30_01_25.GlobalLibrary;

/**
 * Usual book
 */
public class Book {
    /**
     * {@link Book} title
     */
    private final String title;
    private final Genre genre;

    public Book(String title, Genre genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }
}
