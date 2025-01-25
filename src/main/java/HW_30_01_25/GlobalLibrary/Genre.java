package HW_30_01_25.GlobalLibrary;

/**
 * Possible genres
 */
public enum Genre {
    FICTION ("Художественная литература"),
    NONFICTION ("Нехудожественная литература"),
    MYSTERY ("Детектив"),
    THRILLER ("Триллер"),
    SCIENCE ("Научная фантастика"),
    FANTASY ("Фэнтези"),
    ROMANCE ("Романтика"),
    HISTORICAL ("Историческая литература"),
    HORROR ("Ужасы"),
    BIOGRAPHY ("Биография"),
    AUTOBIOGRAPHY ("Автобиография"),
    MEMOIR ("Мемуары"),
    POETRY ("Поэзия"),
    DRAMA ("Драма"),
    COMEDY ("Комедия");

    /**
     * Genre title
     */
    private String title;

    /**
     * Constructor genre
     * @param title genre title
     */
    Genre(String title) {
        this.title = title;
    }

    /**
     * Method returns genre title
     * @return {@link Genre#title}
     */
    public String getTitle() {
        return title;
    }
}
