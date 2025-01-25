package HW_30_01_25.GlobalLibrary;

public class ManuscriptBookAdapter extends Book {
    public ManuscriptBookAdapter(ManuscriptBook manuscriptBook) {
        super(manuscriptBook.getTitle(), manuscriptBook.getGenre());
        System.out.println("ќцифровываем рукописную книгу '" + manuscriptBook.getTitle() + "'...");
    }
}