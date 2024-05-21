package it;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import ru.afanasyev.moviematch.adapter.kinopoisk.RestTemplateProvider;
import ru.afanasyev.moviematch.app.api.GetMovieOutbound;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class AbstractMovieAdapterPostProcessorTest extends IntegrationTest {
    @Autowired
    private GetMovieOutbound service;
    @SpyBean
    private RestTemplateProvider templateProvider;

    @Test
    void testProxy() {
        assertThrows(Exception.class, () -> service.getRandomMovie());

        verify(templateProvider, times(2)).build(anyString());
    }
}