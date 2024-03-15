package vincenzoProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.javafaker.Faker;


public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    Faker faker = new Faker();

    public static void main(String[] args) {
        logger.info("Hello");
    }
}
