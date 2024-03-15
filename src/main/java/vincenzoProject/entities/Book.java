package vincenzoProject.entities;

public class Book extends BiblioItem {

    private final String author;
    private final String genre;

public Book(int isbn, String title, int publicationYear, int pages, String author, String genre) {
    super(isbn, title, publicationYear, pages);
    this.author = author;
    this.genre = genre;
}


}
