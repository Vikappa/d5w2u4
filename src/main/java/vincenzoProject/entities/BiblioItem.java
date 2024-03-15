package vincenzoProject.entities;

import java.time.LocalDate;

public abstract class BiblioItem {
    protected final int ISBN;
    protected final String title;
    protected final int publicationYear;
    protected final int pages;
    private static int lastSbn = 1000;


    public BiblioItem(int isbn, String title, int publicationYear, int pages) {
        lastSbn += 1;
        ISBN = lastSbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.pages = pages;
    }
}
