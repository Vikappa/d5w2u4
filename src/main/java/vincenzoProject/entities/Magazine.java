package vincenzoProject.entities;

public class Magazine extends BiblioItem {

    public enum PublicationFrequency {
        WEEKLY, MONTHLY, HALFYEARLY
    }

    private PublicationFrequency publicationFrequency;

    public Magazine(int codice, String title, int publicationYear, int pages, PublicationFrequency publicationFrequency) {
        super(codice, title, publicationYear, pages);
        this.publicationFrequency = publicationFrequency;
    }
    public Magazine(String title, int publicationYear, int pages, PublicationFrequency publicationFrequency) {
        super(title, publicationYear, pages);
        this.publicationFrequency = publicationFrequency;
    }

    public PublicationFrequency getPublicationFrequency() {
        return publicationFrequency;
    }

    public void setPublicationFrequency(PublicationFrequency publicationFrequency) {
        this.publicationFrequency = publicationFrequency;
    }

    @Override
    public String toString() {
        return this.getISBN() +" - ["+this.title + ", " + this.publicationFrequency + "] " + this.publicationYear + " " + this.pages+" pagine";
    }
}
