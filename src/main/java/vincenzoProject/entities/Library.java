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
            content.put(newItem.getISBN(), newItem);
        }
    }

    @Override
    public String toString() {
        return content.values().stream()
                .map(BiblioItem::toString)
                .collect(Collectors.joining("\n", "Libreria completa:\n", ""));
    }

    public void addElement(BiblioItem element) {
        if (!content.containsKey(element.getISBN())) {
            content.put(element.getISBN(), element);
            System.out.println(element.getPublicationYear() + " aggiunto con ID: " + element.getISBN());
        } else {
            System.out.println("E' già presente un elemento con id: " + element.getISBN() + " e non è stata applicata nessuna modifica.");
        }
    }

    public void removeElement(BiblioItem element) {
        if (content.containsKey(element.getISBN())) {
            content.remove(element.getISBN());
            System.out.println(element.getClass().getSimpleName() + " rimosso");
        } else {
            System.out.println("Nessun elemento trovato con isbn " + element.getISBN());
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

    public void pushElement(BiblioItem element) {
        if (!content.containsKey(element.getISBN())) {
            content.put(element.getISBN(), element);
        } else {
            System.out.println("Elemento con id" + element.getISBN() + " esiste già, nessuna modifica applicata.");
        }
    }

}
