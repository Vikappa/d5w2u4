package vincenzoProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.javafaker.Faker;
import vincenzoProject.entities.Book;
import vincenzoProject.entities.Library;
import vincenzoProject.entities.Magazine;

import java.util.Locale;
import java.util.Scanner;


public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        Faker faker = new Faker(Locale.ITALIAN);

        Scanner scanner = new Scanner(System.in);
        Library libreria = new Library();
        logger.info(libreria.toString());
        logger.info("\n-------------------------------------------------------------------------------------------------------------------");
        logger.info("\nPer semplificare la generazione di isbn univoci e verificabili ho usato un parametro static int di classe incrementato dal \n costruttore, se avessi avuto più tempo avrei implementato una libreria per la generazione di codici alfanumerici.");
        logger.info("Per primo esercizio verrà generato un libro con faker e il suo isbn verrà inserito dall'utente.\nIl libro verrà aggiunto alla libreria e verrà stampata di nuovo per le verifiche. Inserire un isbn già presente\nfarà stampare un messaggio di errore\ne non aggiunge nulla.");
        logger.info("Digita il codice dell'elemento che sta per essere generato, poi sceglierai se aggiungere un libro o una rivista,\n il resto dei parametri verranno aggiunti con Faker: ");

        int codice = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                codice = scanner.nextInt();
                break;
            } else {
                logger.info("Per favore, inserisci un numero intero valido.");
                scanner.next();
            }
        }

        logger.info("Digita 'true' per aggiungere un libro, 'false' per aggiungere una rivista:");
        boolean userChoice = false;

        while (true) {
            String input = scanner.next().trim().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                userChoice = Boolean.parseBoolean(input);
                break;
            } else {
                logger.info("Input errato, digita 'true' o 'false'.");
            }
        }

        if(userChoice) {
            Book toAdd = new Book(
                    codice,
                    faker.book().title(),
                    faker.random().nextInt(1900, 2024),
                    faker.random().nextInt(50, 500),
                    faker.book().author(),
                    faker.book().genre());
            logger.info("Elemento da aggiungere:");
            logger.info(toAdd.toString());
            libreria.pushElement(toAdd);
        } else {
            Magazine toAdd = new Magazine(
                    codice,
                    faker.book().title(),
                    faker.random().nextInt(1900, 2024),
                    faker.random().nextInt(50, 500),
                    Magazine.PublicationFrequency.values()[faker.random().nextInt(0, 2)]);
            logger.info("Elemento da aggiungere:");
            logger.info(toAdd.toString());
            libreria.pushElement(toAdd);
        }

        logger.info(libreria.toString());

        logger.info("\n-------------------------------------------------------------------------------------------------------------------\n");

        logger.info("Ora applicherò il metodo searchByISBN che\n si basa su un imput testuale e ritorna un oggetto BiblioItem da usare come parametro per metodo removeElement");
        logger.info("Digita il codice del libro da rimuovere: ");
        codice = scanner.nextInt();
        libreria.removeElement(libreria.searchByISBN(codice));
        logger.info("Stampo la libreria aggiornata per fare le verifiche: ");
        logger.info(libreria.toString());

        logger.info("\n-------------------------------------------------------------------------------------------------------------------\n");

        logger.info("Adesso applicherò il metodo di ricerca basato sul nome dell'autore, prende in input una stringa e ritorna\nun arraylist di oggetti che hanno un match nel nome. In seguito vengono stampati i risultati");
    }


}
