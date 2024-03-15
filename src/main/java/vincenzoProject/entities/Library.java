package vincenzoProject.entities;
import com.github.javafaker.Faker;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Library {
    private Faker faker = new Faker(Locale.ITALIAN);
    private Map<Integer, BiblioItem> content;

    public Library() {
        content = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            BiblioItem newItem = faker.random().nextBoolean() ?
                    new Book(
                            faker.book().title(),
                            faker.random().nextInt(1900, 2024),
                            faker.random().nextInt(50, 500),
                            faker.book().author(),
                            faker.book().genre())
                    :
                    new Magazine(
                            faker.book().title(),
                            faker.random().nextInt(1900, 2024),
                            faker.random().nextInt(50, 500),
                            Magazine.PublicationFrequency.values()[faker.random().nextInt(Magazine.PublicationFrequency.values().length)]);
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
        if (!content.containsKey(element.getISBN())) {
            content.put(element.getISBN(), element);
            System.out.println(element.getPublicationYear() + " aggiunto con ID: " + element.getISBN());
        } else {
            System.out.println("An element with ID: " + element.getISBN() + " already exists.");
        }
    }

    public void removeElement(BiblioItem element) {
        if (content.containsKey(element.getISBN())) {
            content.remove(element.getISBN());
            System.out.println(element.getClass().getSimpleName() + " removed");
        } else {
            System.out.println("No element found with ID: " + element.getISBN());
        }
    }


    public ArrayList<BiblioItem> searchByPublicationYear(int year) {
        return (ArrayList<BiblioItem>) content.values().stream()
                .filter(biblioItem -> biblioItem.getPublicationYear() == year)
                .collect(Collectors.toList());
    }

    public ArrayList<BiblioItem> searchByAuthor(String author) {
        return (ArrayList<BiblioItem>) content.values().stream()
                .filter(biblioItem -> biblioItem instanceof Book && ((Book) biblioItem).getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public BiblioItem searchByISBN(int isbn) {
        return content.get(isbn);
    }
}
