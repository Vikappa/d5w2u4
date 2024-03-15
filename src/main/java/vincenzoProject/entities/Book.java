package vincenzoProject.entities;

public class Book extends BiblioItem {

    private final String author;
    private final String genre;

public Book( String title, int publicationYear, int pages, String author, String genre) {
    super( title, publicationYear, pages);
    this.author = author;
    this.genre = genre;
}

    @Override
    public String toString() {
        return this.getISBN() +" - ["+this.title + ", " + this.author + "] " + this.genre + " " + this.publicationYear + " " + this.pages+" pagine";
    }
}
