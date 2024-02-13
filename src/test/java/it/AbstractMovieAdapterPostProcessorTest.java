package it;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import ru.afanasyev.adapter.kinopoisk.KinopoiskAdapter;
import ru.afanasyev.adapter.kinopoisk.KinopoiskTokenProvider;
import ru.afanasyev.adapter.kinopoisk.RestTemplateProvider;
import ru.afanasyev.app.api.MovieDataService;
import ru.afanasyev.app.api.TokenProvider;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AbstractMovieAdapterPostProcessorTest extends IntegrationTest {
    @Autowired
    private MovieDataService service;
    @SpyBean
    private RestTemplateProvider templateProvider;

    @Test
    void testProxy() {
        assertThrows(Exception.class, () -> service.getRandomMovie());

        verify(templateProvider, times(2)).build(anyString());
    }
}