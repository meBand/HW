package HW_30_01_25.GlobalLibrary;

/**
 * Usual manuscript book
 */
public class ManuscriptBook {
    /**
     * {@link ManuscriptBook} title
     */
    private String title;

    /**
     * {@link ManuscriptBook} genre
     */
    private Genre genre;

    /**
     * Constructor of {@link ManuscriptBook}
     * @param title {@link ManuscriptBook} title
     * @param genre {@link ManuscriptBook} genre
     */
    public ManuscriptBook(String title, Genre genre) {
        this.title = title;
        this.genre = genre;
    }

    /**
     * Method returns manuscript book title
     * @return {@link #title}
     */
    public String getTitle() {
        return title;
    }

    /**
     * Method returns manuscript book genre
     * @return {@link #genre}
     */
    public Genre getGenre() {
        return genre;
    }
}
