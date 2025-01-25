package HW_30_01_25.GlobalLibrary;

public class ManuscriptBook {
    private String name;
    private Genre genre;

    public ManuscriptBook(String name, Genre genre) {
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
