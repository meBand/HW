package HW_30_01_25.GlobalLibrary;

/**
 * Usual manuscript book
 */
public class Manuscript {
    /**
     * {@link Manuscript} title
     */
    private String title;

    /**
     * {@link Manuscript} genre
     */
    private Genre genre;

    /**
     * Constructor of {@link Manuscript}
     * @param title {@link Manuscript} title
     * @param genre {@link Manuscript} genre
     */
    public Manuscript(String title, Genre genre) {
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
