package HW_30_01_25.GlobalLibrary;

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

    private String title;

    Genre(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
