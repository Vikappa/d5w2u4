package vincenzoProject.entities;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Library {
    private Faker faker = new Faker(Locale.ITALIAN);
    private ArrayList<BiblioItem> content;

    public Library() {

        boolean moneta = faker.random().nextBoolean();

        content = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            if(moneta) {
                content.add(new Book(
                        faker.book().title(),
                        faker.random().nextInt(1900, 2024),
                        faker.random().nextInt(50, 500),
                        faker.book().author(),
                        faker.book().genre()));
            } else {
                content.add(new Magazine(
                        faker.book().title(),
                        faker.random().nextInt(1900, 2024),
                        faker.random().nextInt(50, 500),
                        Magazine.PublicationFrequency.values()[faker.random().nextInt(0, 2)]));
            }
        }
    }

    @Override
    public String toString() {
        String ritorno = "Libreria completa:\n";
        for (BiblioItem biblioItem : content) {
            ritorno += biblioItem.toString() + "\n";
    }
        return ritorno;
    }


    public void addElement(BiblioItem element) {
        AtomicBoolean isPresent = new AtomicBoolean(false);
        content.forEach(biblioItem -> {
            if (biblioItem.getISBN() == element.getISBN()) {
                isPresent.set(true);
            }
        });

        if (!isPresent.get()) {
            content.add(element);
        }
    }

    public void removeElement(BiblioItem element) {
        this.content = (ArrayList<BiblioItem>) this.content.stream()
                .filter(biblioItem -> biblioItem.getISBN() == element.getISBN())
                .collect(Collectors.toList());
    }

    public ArrayList<BiblioItem> searchByPublicationYear(int year) {
        return (ArrayList<BiblioItem>) this.content.stream()
                .filter(biblioItem -> biblioItem.getPublicationYear() == year)
                .collect(Collectors.toList());
    }
}
