package it;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.afanasyev.moviematch.fw.MovieMatchApplication;

@SpringBootTest(classes = {MovieMatchApplication.class})
@ActiveProfiles({"test"})
abstract class AbstractIntegrationTest {
}
