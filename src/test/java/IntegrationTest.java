import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.afanasyev.app.api.MovieDataService;
import ru.afanasyev.fw.MovieMatchApplication;

@SpringBootTest(classes = {MovieMatchApplication.class})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class})
@ActiveProfiles({"test"})
class IntegrationTest {
    @Autowired
    private MovieDataService kinopoiskAdapter;

    @Test
    void test() {
        System.out.println(kinopoiskAdapter.getRandomMovie());
    }
}
