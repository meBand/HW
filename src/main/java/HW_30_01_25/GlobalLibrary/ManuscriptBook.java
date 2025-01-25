package HW_30_01_25.GlobalLibrary;

public class ManuscriptBook {
    private String title;
    private Genre genre;

    public ManuscriptBook(String title, Genre genre) {
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
