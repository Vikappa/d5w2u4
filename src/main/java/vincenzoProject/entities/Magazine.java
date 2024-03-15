package vincenzoProject.entities;

public class Magazine extends BiblioItem {

    public enum PublicationFrequency {
        WEEKLY, MONTHLY, HALFYEARLY
    }

    private PublicationFrequency publicationFrequency;

    public Magazine(int isbn, String title, int publicationYear, int pages, PublicationFrequency publicationFrequency) {
        super(isbn, title, publicationYear, pages);
        this.publicationFrequency = publicationFrequency;
    }

    public PublicationFrequency getPublicationFrequency() {
        return publicationFrequency;
    }

    public void setPublicationFrequency(PublicationFrequency publicationFrequency) {
        this.publicationFrequency = publicationFrequency;
    }

}
