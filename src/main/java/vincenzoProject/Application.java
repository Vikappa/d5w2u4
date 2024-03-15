package vincenzoProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.javafaker.Faker;
import vincenzoProject.entities.Library;


public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    Faker faker = new Faker();

    public static void main(String[] args) {
        Library libreria = new Library();
        logger.info(libreria.toString());
    }



}
