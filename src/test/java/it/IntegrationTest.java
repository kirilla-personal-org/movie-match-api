package it;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.afanasyev.moviematch.fw.MovieMatchApplication;

@SpringBootTest(classes = {MovieMatchApplication.class})
@ActiveProfiles({"test"})
class IntegrationTest {
    @Test
    void contextLoads(){

    }
}
