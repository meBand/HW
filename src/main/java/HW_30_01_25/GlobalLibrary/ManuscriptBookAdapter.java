package HW_30_01_25.GlobalLibrary;

/**
 * Adapter converts a {@link Manuscript} into a {@link Book}
 */
public class ManuscriptBookAdapter extends Book {
    /**
     * Constructor converts a {@link Manuscript} into a {@link Book}
     * @param manuscript {@link Manuscript}
     */
    public ManuscriptBookAdapter(Manuscript manuscript) {
        super(manuscript.getTitle(), manuscript.getGenre());
        System.out.println("ќцифровываем рукописную книгу '" + manuscript.getTitle() + "'...");
    }
}