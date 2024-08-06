import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.afanasyev.moviematch.app.ipr.beanmanagement.ValidationExecutor;
import ru.afanasyev.moviematch.app.ipr.beanmanagement.Validator;
import ru.afanasyev.moviematch.fw.MovieMatchApplication;

/**
 * https://www.baeldung.com/spring-primary
 * https://www.baeldung.com/spring-order
 */
@SpringBootTest(classes = {MovieMatchApplication.class})
@ActiveProfiles({"test"})
class BeanManagementTest {
    @Autowired
    private ValidationExecutor executor;
    @Autowired
    private Validator primaryValidator;

    @Test
    void test() {
        executor.validate("$1");
        primaryValidator.validate("$2");
    }
}
