package HW_30_01_25.GlobalLibrary;

/**
 * Usual book
 */
public class Book {
    /**
     * {@link Book} title
     */
    private final String title;

    /**
     * {@link Book} genre
     */
    private final Genre genre;

    /**
     * Constructor of {@link Book}
     * @param title {@link Book} title
     * @param genre {@link Book} genre
     */
    public Book(String title, Genre genre) {
        this.title = title;
        this.genre = genre;
    }

    /**
     * Method returns book title
     * @return {@link #title}
     */
    public String getTitle() {
        return title;
    }

    /**
     * Method returns book genre
     * @return {@link #genre}
     */
    public Genre getGenre() {
        return genre;
    }
}
